#Author:sangram
#Feature: Login Features
#Date: 11/09/2019
@SmokeTest
Feature:Login feature 
        Verify the login feature of marcurry tours application
        
        Background:User access Login screen of Mercury Tours application
            When user opens "chrome" browser
            And user enters application url "http://www.newtours.demoaut.com/mercurywelcome.php"
            And user waits "20" seconds to load login page
            And user maximize the chrome browser
            Then user is on login screen of Mercurry Tours application
            
            
            @SmokeTest
            Scenario: Verify that valid user able to login into Mercurry Tours application by using valid usernameand password
            Given user access login screen of Mercurry Tours application
             When user enters "Suvidyap1" as username
             And user enters "P@ssword1" as password
             And user clicks on Signin button
             Then user is on flight finder Page
             When user clicks on SignOff link
             Then user is on sing in Screen  
            
            
            
            
         