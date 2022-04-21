# java-restful-api-spring-boot
Full source code for blog post: https://www.favtuts.com/how-to-build-a-java-restful-api-with-spring-boot/

# how to build and run project

To compile the project
```
mvn compile
```

To run the Spring Boot application
```
mvn spring-boot:run
```

To generate Java sources (POJO classes) from json schema files
```
mvn generate-sources
```


# how to test REST API

To check controller works with PING
```
curl http://localhost:8080/imageclient/images/ping
```

To get images with a list of metadata query parameters
```
curl http://localhost:8080/imageclient/images?meta-data=name1=value1&meta-data=name2=value2&meta-data=name3=value3 | jq
```

To get image by ID
```
curl http://localhost:8080/imageclient/images/123
```

To update image full overwrite
```
curl --location --request PUT 'http://localhost:8080/imageclient/images/123' \
--header 'Content-Type: application/json' \
--data-raw '{
    "image-id": "445",
    "image-format": "jpg",
    "image-path": "http://www.nowhere.com/image-binary-url/image123.png",
    "meta-data": [
        {
            "name": "name0",
            "value": "value0"
        },
        {
            "name": "name1",
            "value": "value1"
        }        
    ]
}'
```


To update image by ID (Partial Update)
```
curl --location --request PATCH 'http://localhost:8080/imageclient/images/123' \
--header 'Content-Type: application/json' \
--data-raw '{
    "image-id": "445",
    "image-format": "jpg",
    "image-path": "http://www.nowhere.com/image-binary-url/image123.png",
    "meta-data": [
        {
            "name": "name0",
            "value": "value0"
        },
        {
            "name": "name1",
            "value": "value1"
        }        
    ]
}'
```