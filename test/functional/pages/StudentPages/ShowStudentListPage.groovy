package pages.StudentPages


import geb.Page

class ShowStudentListPage extends Page {
	static url = "student/index"

	static at = {
		title ==~ /Show List of Students/
	}

	def boolean checkForStudent(String login) {
		return !($("tr").has("a", name: login)) 
		
	}

}
