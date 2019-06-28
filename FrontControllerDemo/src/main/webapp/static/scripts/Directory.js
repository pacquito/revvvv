/**
 * JavaScript used to render employee information on Directory.html
 */

// make an AJAX request to the endpoint that gives us the needed data, that endpoint being: http://localhost:8080/ServletDemo/employees

//console.log("Working");

let employeeUrl = "http://localhost:8080/FrontControllerDemo/api/employees";
	
function sendAjaxGet(url, callback){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			callback(this);
		}
		
	}
	xhr.send();
	
}
function displayEmployees(xhr){
	let employees = JSON.parse(xhr.response);
	let tabe = document.getElementById("table");
	
	for(i in employees){
		let newRow = document.createElement("tr");
		
		let dpt = "n/a";
		if(employees[i].department && employees[i].department.name){
			dpt = employees[i].department.name;
		}
		newRow.innerHTML = `<td>${employees[i].name}</td><td>${dpt}</td>`;
		
		tabe.appendChild(newRow);
	}
}
sendAjaxGet(employeeUrl, displayEmployees)