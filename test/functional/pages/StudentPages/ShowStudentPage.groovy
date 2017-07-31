package pages.StudentPages


import geb.Page

/**
 * Created by Lapp on 24/06/2016.
 */
class ShowStudentPage extends Page {
    static url = "student/show"

    static at = {
        title ==~ /Show Student/
    }

    def boolean checkForCriterion(String desc) {
        if ($("tbody").has("a", name: desc)) return false
        return true
    }

    def selectCriterionByDesc(String desc) {
        $("td").find("a", name: desc).click()
    }

    def selectCriterion(String name){
        $("tr").find("td").has("a",text: name).click()
    }
	
	def clickDelete(){
		boolean b = false
		if ($("input", class: "delete").isDisplayed()) b = true
	}
	
	def confirmationMessage(){
		if ($("input", class: "delete").isDisplayed())
			withConfirm {$("input", class: "delete").click()}
	}
	
	def message() {
		$("g", class: "message").isDisplayed()
	}
	
	def boolean selectDeleteStudent() {
		boolean b = false
		if ($("input", class: "delete").isDisplayed()) b = true
		if(b) {
			withConfirm {$("input", class: "delete").click()}
		}
	}
}
