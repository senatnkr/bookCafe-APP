TR
# Book Cafe App - Java Backend Gelistirme Akademisi Spring Boot Edition 

Book cafe App, Java Backend Gelistirme Akademisi kapsamında bitirme projesi olarak Java Spring Boot ile geliştirilmiş bir backend uygulamasıdır.
Bu proje, kitap kafe de bulunan kitapların satılma ve kiralanma işlemlerinin yapılabilmesini sağlar. 

## Özellikler

- **Spring Boot:** RESTful API geliştirmek için kullanılmıştır.
- **Veritabanı Entegrasyonu:** Spring Data JPA kullanılarak CRUD işlemleri gösterilmiştir.
- **Hata Yönetimi:** Uygulama genelinde etkili hata yönetimi ve istisna yakalama mekanizmaları uygulanmıştır.
- **Transaction Yönetimi:** Veritabanı işlemlerinde transaction yönetimi sağlanmıştır.

## Başlangıç

### Gereksinimler

Projeyi çalıştırmak için sisteminizde aşağıdaki yazılımların kurulu olması gerekmektedir:

- Java 17 veya üstü
- Maven 3.8 veya üstü
- Docker ve Docker Compose (opsiyonel)
- IntelliJ IDEA veya başka bir IDE
- MYSQL veya uyumlu başka bir SQL veritabanı

### Kurulum

1. **Projeyi klonlayın:**

   ```bash
   git clone https://github.com/senatnkr/bookCafe-APP.git
   ```

2. **Veritabanını yapılandırın:**

   - `bookcafe` adında bir veritabanı oluşturun (Docker ile çalıştırılacaksa bu adım gerekmez).
   - `src/main/resources` klasöründeki `application.properties` dosyasını veritabanı bilgilerinize göre güncelleyin.

3. **Projeyi Maven ile derleyin:**

   ```bash
   mvn clean install
   ```

4. **Spring Boot uygulamasını çalıştırın:**

   ```bash
   mvn spring-boot:run
   ```

   Uygulama başlatıldıktan sonra API'leri kullanmaya başlayabilirsiniz.

5. **Docker ile çalıştırma (opsiyonel):**

   Uygulamayı Docker ile çalıştırmak için, projenin kök dizininde bulunan `docker-compose.yml` dosyasını kullanabilirsiniz:

   ```bash
   docker-compose up --build
   ```

## API Endpoints
 
![Swagger UI - Google Chrome 10_5_2024 3_15_19 AM.png](..%2FSwagger%20UI%20-%20Google%20Chrome%2010_5_2024%203_15_19%20AM.png)

Book Cafe App uygulaması şu endpointleri sunar:


![Swagger UI - book.png](..%2FSwagger%20UI%20-%20book.png)

- `PUT /api/book/sell/{id}`: Satma işlemini burada yapıyoruz
- `PUT /api/book/rent/{id}`: Mevcut bir kitabın detaylarını günceller. Kiralama işlemini burada yapıyoruz
- `POST /api/book/add`: Envantere yeni bir kitap ekler.
- `GET /api/book/all`: Tüm mevcut kitapların listesini getirir.



![Swagger UI - user.png](..%2FSwagger%20UI%20-%20user.png)


- `POST /api/users/register`: Yeni bir kullanıcı ekler.
- `GET /api/users/{id}`:  Belirtilen kullanıcı kimliği ile ilgili kullanıcı bilgilerini getirir.
- `GET /api/users/all`: Tüm mevcut kullanıcıların listesini getirir.


![Swagger UI - register.png](..%2FSwagger%20UI%20-%20register.png)

- `POST /api/register`: Kayıt Kontrolü


![Swagger UI - cart.png](..%2FSwagger%20UI%20-%20cart.png)

- `POST /api/carts/{userId}/add/{bookId}`: Sepete yeni bir kitap ekler.
- `GET /api/carts/{userId}`: Tüm sepetin listesini getirir.
- `DELETE /api/carts/{userId}/remove/{bookId}`: Sepetten silme işlemini burada yapıyoruz

# Proje Görünümü

![1.png](..%2F1.png)
![2.png](..%2F2.png)

## Kullanılan Teknolojiler

- **Java 17:** Backend mantığı için kullanılan ana programlama dili.
- **Spring Boot:** RESTful servislerin hızlı geliştirilmesi için kullanıldı.
- **Spring Data JPA:** Veritabanı işlemlerini basitleştiren bir Spring modülü.
- **Maven:** Proje bağımlılık yönetimi ve derleme işlemleri.
- **Docker & Docker Compose:** Uygulamayı ve MYSQL veritabanını kapsayıcı olarak çalıştırmak için kullanılır.
- **MYSQL:** Veritabanı yönetim sistemi olarak kullanılmıştır.


## Katkıda Bulunanlar

Bu proje, Java Backend Geliştirme Akademisi kapsamında bitirme projesi olarak geliştirilmiştir.

## Lisans

Bu proje MIT Lisansı altında lisanslanmıştır. Daha fazla bilgi için `LICENSE` dosyasına bakın.


---

ENG
# Book Cafe App - Java Backend Development Academy Spring Boot Edition

The Book Cafe App is a backend application developed with Java Spring Boot as a graduation project under the Java Backend Development Academy. This project enables the buying and renting of books available in the book cafe.

## Features

- **Spring Boot:** Used for developing RESTful APIs.
- **Database Integration:** CRUD operations are demonstrated using Spring Data JPA.
- **Error Management:** Effective error handling and exception catching mechanisms have been implemented throughout the application.
- **Transaction Management:** Transaction management is provided for database operations.

## Getting Started

### Requirements

To run the project, the following software must be installed on your system:

- Java 17 or higher
- Maven 3.8 or higher
- Docker and Docker Compose (optional)
- IntelliJ IDEA or another IDE
- MySQL or another compatible SQL database

### Installation

1. **Clone the project:**

   ```bash
   git clone https://github.com/senatnkr/bookCafe-APP.git
   ```
   4. **Run the Spring Boot application:**

   ```bash
   mvn spring-boot:run
   ```

   After starting the application, you can begin using the APIs.
5. **Running with Docker (optional):**

   To run the application using Docker, you can use the docker-compose.yml file located in the root directory of the project:
   
   ```bash
   docker-compose up --build
   ```

## API Endpoints

![Swagger UI - Google Chrome 10_5_2024 3_15_19 AM.png](..%2FSwagger%20UI%20-%20Google%20Chrome%2010_5_2024%203_15_19%20AM.png)

The Book Cafe App provides the following endpoints:

![Swagger UI - book.png](..%2FSwagger%20UI%20-%20book.png)
- PUT /api/book/sell/{id}: Handles the book selling process.
- PUT /api/book/rent/{id}: Updates the details of an existing book. Handles the book renting process.
- POST /api/book/add: Adds a new book to the inventory.
- GET /api/book/all: Retrieves a list of all available books.

![Swagger UI - user.png](..%2FSwagger%20UI%20-%20user.png)

- POST /api/users/register: Adds a new user.
- GET /api/users/{id}: Retrieves user information for the specified user ID.
- GET /api/users/all: Retrieves a list of all existing users.


![Swagger UI - register.png](..%2FSwagger%20UI%20-%20register.png)

- POST /api/register: Registration verification.

![Swagger UI - cart.png](..%2FSwagger%20UI%20-%20cart.png)

- POST /api/carts/{userId}/add/{bookId}: Adds a new book to the cart.
- GET /api/carts/{userId}: Retrieves the entire cart list.
- DELETE /api/carts/{userId}/remove/{bookId}: Handles the removal of items from the cart.

# Project View

![1.png](..%2F1.png)
![2.png](..%2F2.png)

## Technologies Used
- **Java 17:** The primary programming language used for the backend logic.
- **Spring Boot:** Used for the rapid development of RESTful services.
- **Spring Data JPA:** A Spring module that simplifies database operations.
- **Maven:** Used for project dependency management and build processes.
- **Docker & Docker Compose:** Used to run the application and the MySQL database in containers.
- **MySQL:** Used as the database management system.


## Contributors
This project has been developed as a graduation project under the Java Backend Development Academy.

## License
This project is licensed under the MIT License. See the LICENSE file for more information.