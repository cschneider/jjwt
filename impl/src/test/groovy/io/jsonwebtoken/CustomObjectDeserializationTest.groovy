package io.jsonwebtoken

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.jsontype.NamedType
import com.fasterxml.jackson.databind.type.MapType
import com.fasterxml.jackson.databind.type.TypeFactory
import io.jsonwebtoken.io.Deserializer
import io.jsonwebtoken.io.JacksonDeserializer
import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull

class CustomObjectDeserializationTest {

    @Test
    void testCustomObject() {

        Date expectedDate = new Date()
        CustomBean customBean = new CustomBean()
        customBean.key1 = "value1"
        customBean.key2 = 42
        customBean.nested = new NestedBean()
        customBean.nested.nestedValue = "i am nested"
        customBean.nested.someDate = expectedDate

        String jwtString = Jwts.builder().claim("cust", customBean).compact()

        // no custom deserialization, object is a map
        Jwt<Header, Claims> jwt = Jwts.parser().parseClaimsJwt(jwtString)
        assertNotNull jwt
        assertEquals jwt.getBody().get("cust"), [key1: 'value1', key2: 42, nested: [nestedValue: 'i am nested', someDate: expectedDate.time]]

        // custom deserializer, `cust` field is mapped as CustomBean
        ObjectMapper mapper = new ObjectMapper()
//        TypeFactory typeFactory = mapper.getTypeFactory()
//        MapType mapType = typeFactory.constructMapType(HashMap.class, String.class, CustomBean.class)
        mapper.registerSubtypes(new NamedType(CustomBean, "cust"))
        Deserializer deserializer = new JacksonDeserializer(mapper)
        jwt = Jwts.parser().deserializeJsonWith(deserializer).parseClaimsJwt(jwtString)
        assertNotNull jwt
        CustomBean result = jwt.getBody().get("cust", CustomBean)

    }

    static class CustomBean {
        private String key1
        private Integer key2
        private NestedBean nested

        String getKey1() {
            return key1
        }

        void setKey1(String key1) {
            this.key1 = key1
        }

        Integer getKey2() {
            return key2
        }

        void setKey2(Integer key2) {
            this.key2 = key2
        }

        NestedBean getNested() {
            return nested
        }

        void setNested(NestedBean nested) {
            this.nested = nested
        }
    }

    static class NestedBean {
        private String nestedValue
        private Date someDate

        String getNestedValue() {
            return nestedValue
        }

        void setNestedValue(String nestedValue) {
            this.nestedValue = nestedValue
        }

        Date getSomeDate() {
            return someDate
        }

        void setSomeDate(Date someDate) {
            this.someDate = someDate
        }
    }
}
