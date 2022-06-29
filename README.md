This is an implementation of a REST API to register customers and order pizzas online. The customer can choose a variety of toppings to add to the pizza, at no extra cost.

The project is implemented in Java and uses Spring Boot.

It uses a simple 3 layer design with a controller layer to handle requests to the server, a service layer to process business logic, and a repository layer which uses Hibernate to persist customer accounts, pizza orders, and purchase transactions to the database.

It uses an in-memory database (H2).

The implemented endpoints are:
1. GET "/version" (provides the version of the app).
2. GET "/order/{id}" (retrieves a previous order with id value {id}).
3. POST "/register" (registers a new customer whose data is provided as JSON in the request body).
4. POST "/order" (places a new order whose details are provided as JSON in the request body).
5. PUT "/order/{id}" (updates a previous order with a new order, provided as JSON in the request body. Only updated if order has not been dispatched).
6. DELETE "/order/{id}" (deletes a previous order if it has not already been dispatched).

The project contains a POSTMAN file in the root directory which provides example API requests.
