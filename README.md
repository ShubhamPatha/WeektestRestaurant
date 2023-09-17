# WeektestRestaurant

## FRAMEWORK AND LANGUAGE USED
* JAVA 17
* MAVEN
* SPRINGBOOT 3.1.1
<!-- Headings -->   
## DATA FLOW



  ### CONFIGURATION
  ```
package com.geekster.Restaurant.configuration;

import com.geekster.Restaurant.model.Res;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanManager {
    @Bean
    public List<Res> getInitializedList()
    {

       Res initUser = new Res("Headquarter","Delhi-Dwarka",1,"Kulfi",10);

        List<Res> initList = new ArrayList<>();
        initList.add(initUser);


        return initList;
    }

}

```


 ### CONTROLLER
  ``` 
package com.geekster.Restaurant.controller;

import com.geekster.Restaurant.model.Res;
import com.geekster.Restaurant.service.Resservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Rescontroller {
@Autowired
    Resservice resservice;

@GetMapping("Restaurant/List")
    List<Res> getAllRestaurant(){  return  resservice.getAllRest();}

    @PostMapping("Restaurant/List/add")
    String addUsers(@Valid @RequestBody List<Res> Rest)
    {
        return resservice.addRes(Rest);
    }

    @GetMapping("Restaurant/{restaurantId}")
    Res getResdetail(@PathVariable Integer restaurantId)
    {
        return resservice.getUserdetail(restaurantId);
    }

    @PutMapping("Restaurant/{restaurantId}")
    String ResSpeciality(@PathVariable Integer restaurantId, Res Rest)
    {
        return resservice.updateuser(restaurantId,Rest);
    }

    @DeleteMapping("Restaurant/{restaurantId}")
    String removeUser(@PathVariable Integer restaurantId)
    {
        return resservice.removeUser(restaurantId);
    }




}
```


 ### MODEL
  ``` 
package com.geekster.Restaurant.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Res {


    private String restaurantName;
    @NotBlank(message = "name cannot be blank")
    private String restaurantAddress;
    @NotBlank(message = "name cannot be blank")
    private Integer restaurantId;

    private String restaurantSpeciality;
    @Min(value = 3)
    private Integer restaurantStaffs;

}
```

### REPO
  ``` 
package com.geekster.Restaurant.repository;

import com.geekster.Restaurant.model.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResRepo {

    @Autowired
    private List<Res> userList;

    public List<Res> getUsers() {
        return userList;}



}

```


### SERVICE
  ``` 
package com.geekster.Restaurant.service;

import com.geekster.Restaurant.model.Res;
import com.geekster.Restaurant.repository.ResRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Resservice {
    @Autowired
    ResRepo resrepo;

    public  Res getUserdetail(Integer restaurantId) {

        List<Res> originalList = getAllRest();
        Res r1=new Res();
        for(Res res1:originalList)
        {
            if(res1.getRestaurantId()==restaurantId)
            {
                r1=res1;
                return r1;
            }
        }

        return  r1;
    }

    public List<Res> getAllRest() {
        return resrepo.getUsers();
    }



    public String addRes(List<Res> rest) {
        List<Res> originalList = getAllRest();
        originalList.addAll(rest);
        return "New users added";

    }


    public String updateuser(Integer userId, Res rest) {


        List<Res> originalList = getAllRest();

        for(Res user1: originalList)
        {
            if(user1.getRestaurantId()==userId)
            {
                user1=rest;
                return "updated";
            }
        }

        return "not found";
    }

    public String removeUser(Integer restaurantId) {


        List<Res> originalList = getAllRest();

        for(Res user1: originalList)
        {
            if(user1.getRestaurantId()==restaurantId)
            {
                originalList.remove(user1);
                return "user deleted";
            }
        }

        return  "user not found";
    }
}

```


### MAIN
  ``` 
package com.geekster.Restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}

}

```


 ### POM
  ```

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.1.1</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.geekster</groupId>
	<artifactId>Restaurant</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>Restaurant</name>
	<description>Demo project for Spring Boot</description>
	<properties>
		<java.version>17</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
		</plugins>
	</build>

</project>

```
## DATA STRUCTURE USED
* LIST 
* STRING
* LOCAL DATE
* INTEGER
* USER

# PROJECT SUMMARY

## Restaurant Management System Has been created with the following attribute

* UserId
* username
* DateOfBirth
* Email
* Phone Number
* Date 
* Time
### Endpoint to be provided 
* AddUser 
* getUser/{userid}
* getAllUser
* updateUserInfo
* deleteUser









<!-- Headings -->   
# Author
SHUBHAM PATHAK
 <!-- UL -->
* Twitter <!-- Links -->
[@ShubhamPathak]( https://twitter.com/Shubham15022000)
* Github  <!-- Links -->
[@ShubhamPathak]( https://github.com/ShubhamPatha)
<!-- Headings -->   
