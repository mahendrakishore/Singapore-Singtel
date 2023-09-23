Feature: Test the typicode posts, comment and user list json request

  @posts-post
  Scenario: User make a  posts
    Given User make a posts on typidode with below values
      | userId | title | body |
      |     10 | foo   | bar  |

  @comment-post
  Scenario Outline: User make a  comment on a posts
    Given User make a comment with below values
      | name             | email              | body        |
      | name foo comment | mahen_ki@yahoo.com | bar comment |
      
    And User post the comment on postsid "<postid>" on typidode
    Examples: 
      | postid |
      |    100 |

  @posts-get
  Scenario: User get all the list of post
    Given User hit the typidode get request
