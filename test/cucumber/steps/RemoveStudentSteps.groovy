package steps

import pages.StudentConsultPage
import pages.AddStudentsPage
import pages.StudentPages.ShowStudentPage
import pages.StudentPages.ShowStudentListPage
import pages.StudentPages.StudentPage
import steps.AddStudentsTestDataAndOperations
import ta.Student
import ta.StudentController;

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

//Scenario: Remove student registered in the system
Given(~'^a student with name "([^"]*)" and login "([^"]*)" is registered in the system$'){
	String name, String login ->
	AddStudentsTestDataAndOperations.createStudent(name, login)
	assert Student.findByLogin(login) !=null
	
}

When(~'^I remove the student with name "([^"]*)" and login "([^"]*)"$'){ String name, String login ->
	Student student = Student.findByLogin(login) 
	AddStudentsTestDataAndOperations.removeStudent(student)
	
}

Then(~'^The student with name "([^"]*)" and login "([^"]*)" is removed from the system$'){ String name, String login ->
	assert Student.findByLogin(login) == null
}


//Scenario: Confirmation message after removing student
Given(~'I am at the page of the student "([^"]*)" with login "([^"]*)"$'){ String name, String login ->
	AddStudentsTestDataAndOperations.createStudent(name, login)
	to StudentPage
	at StudentPage
	assert page.confirmStudent(name, login)
	stu = Student.findByLogin(login)
	page.selectStudentByLogin(login)
	at ShowStudentPage
}

When(~'^I click remove$'){->
	//assert page.selectDeleteStudent()
	assert page.clickDelete()
}

Then(~'^Show confirmation message of remove$'){->
	page.message()
}