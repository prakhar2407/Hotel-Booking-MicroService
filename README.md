# Hotel-Booking-MicroService

To Run this Project we first have to run the eureka server, when it is up and running we can start with any of the microservices and we have to make sure that they are discoverable and visible on the Eureka Server (localhost:8761)  
As the Microservices are self capable and loosely coupled we have used the Rest Template class to call the api of other microservice to fetch,post,put,delete data from other microservice
  For Rest Template to work we have to create a Bean for Rest Template in the class where main method is present and in that microservice from which we want to make the   api call
  
  ![image](https://user-images.githubusercontent.com/65302454/205005915-ee787574-e225-46c9-800f-16601e9586e2.png)

# Booking Microservice Creation
![image](https://user-images.githubusercontent.com/65302454/204792391-19a27569-ed53-42a8-bab7-72ed4d49eb71.png)

# Eureka Server Creation
![image](https://user-images.githubusercontent.com/65302454/204797821-088f6883-9519-45a7-b9fa-b7689059d608.png)

# Payment Microservice Creation
![image](https://user-images.githubusercontent.com/65302454/204823268-056b8d71-c8c7-48df-b318-1c0434511f87.png)


# EUREKA SERVER
![image](https://user-images.githubusercontent.com/65302454/204842472-32f68520-aeaf-4257-8ef0-186818a41617.png)

# FOLDER STRUCTURE
![image](https://user-images.githubusercontent.com/65302454/204845826-7faeab00-2b33-4f60-a11b-7c33890be974.png)

# EUREKA SERVER MAIN METHOD
![image](https://user-images.githubusercontent.com/65302454/204845990-04559eea-b474-477c-b8e5-fc1067d59509.png)

# REST TEMPLATE TO SEND REQUEST FROM ONE MICROSERVICE TO ANOTHER
![image](https://user-images.githubusercontent.com/65302454/204847870-e95640c0-e7ea-4cb5-a69b-7530b9f968b8.png)
