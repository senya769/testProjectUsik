# testProjectUsik

- Java 8 или выше
- Spring Boot
- Spring Web
- Spring Data JPA
- mySQL JDBC драйвер

## Сборка и запуск приложения

1. Клонируйте репозиторий: `git clone <repository_url>`
2. Перейдите в директорию проекта: `cd <project_directory>`
3. Соберите проект с помощью Maven: `mvn clean install`
4. Запустите приложение: `java -jar <jar_file_name>.jar`

## примерs запроса
curl -X GET http://localhost:9090/v1/shops
curl -X POST -H "Content-Type: application/json" 
-d '{"name":"Product 1","price":10.99,"description":"Description","manufacturer":"Manufacturer","category":"Category"}' http://localhost:9090/v1/shop/1/product
