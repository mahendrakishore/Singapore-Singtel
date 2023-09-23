
Feature: Test the typicode posts, comment and user list json request


 @posts-post
  Scenario: User make a  posts
    Given User make a posts on typidode with below values
    | userId | title | body |
    |   10   |  foo1  | bar1 |
    
        
  @posts-get
  Scenario: User get all the list of post
    Given User hit the typidode get request


  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
