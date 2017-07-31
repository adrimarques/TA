Feature: Remove Evaluation
  As the teacher
  I want to remove a student
  So that i can have an updated list of my students


#Controller
 Scenario: Remove student registered in the system
  Given a student with name "August" and login "gus01" is registered in the system 
  When I remove the student with name "August" and login "gus"
  Then The student with name "August" and login "gus" is removed from the system



#GUI
 Scenario: Confirmation message after removing student
  Given I am at the page of the student "Arthur" with login "art"
  When I click remove 
  Then Show confirmation message of remove

  
  