/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//validates for 1st form
function validateForm(){
    
     var fElem = document.mForm.elements.length;
     for(var i = 0; i < fElem - 5; i++)
     {
         var x = document.forms["mForm"].elements[i].value;
         if( x==="" || x=== null )
         {
             alert("All fields must be specified before continuing");
             return false;
         }
         else if(!validateNumEntry(x))
         {
             alert("Fields must cointain only positive numbers");
             return false;
         }
         
     }
        
     if(!validateSumSubs())
     {
         alert("Sum or Substraction operation cannot be processed.Verify that the colums and row for\n\
                from Matrix1 be the same as the columns and rows from Matrix2");
        return false;
     }
     else if(!validateProductDot())
     {
         alert("Product or Dot Product operation cannot be processed.Verify that the columns from Matrix1\n\
               matches the columns from Matrix2");
        return false;
     }
     
    return true;
}
//validates matrixForm1
function validateMatrix1(){
    var fElem = document.resultForm.elements.length;
     for(var i = 0; i < fElem-1; i++)
     {
         var x = document.forms["resultForm"].elements[i].value;
         if( x==="" || x=== null)
         {
             alert("All fields must be specified before continuing");
             return false;
         }
         else if(!validateCells(x))
         {
             alert("Fields must cointain only positive or negative floating or whole numbers");
             return false;
         }  
     }
     return true;
}
//validates matrix with dot product
function validateMatrix2(){
   var fElem = document.resultForm.elements.length;
     for(var i = 0; i < fElem - 3; i++)
     {
         var x = document.forms["resultForm"].elements[i].value;
         if( x==="" || x=== null )
         {
             alert("All fields must be specified before continuing");
             return false;
         }
         else if(!validateCells(x))
         {
             alert("Fields must cointain only positive or negative floating or whole numbers");
             return false;
         }
    }
         x = document.forms["resultForm"]["dprow"].value;
         var y = document.forms["resultForm"]["dpcol"].value;
         
         if((x ==="" || x===null) || (y==="" || y===null))
         {
             alert("All fields must be specified before continuing.");
             return false;
         }
         else if(!validateNumEntry(x) || !validateNumEntry(y))
         {
             alert("Field must contain only positive whole numbers");
             return false;
         }
      
     
     return true;
}


//validates radio button for sum operation
function validateSumSubs(){
    var row1 = document.forms["mForm"]["rows1"].value;
    var row2 = document.forms["mForm"]["row2"].value; 
    var col1 = document.forms["mForm"]["cols1"].value;
    var col2 = document.forms["mForm"]["col2"].value;
    var sum = document.getElementById("1").checked;
    var subs = document.getElementById("2").checked;
    
    if(((row1 !== row2) || (col1 !== col2)) && ((sum) || (subs)))
        return false;   
    else
       return true;   
}
//validates radio button for Dot Product operation
function validateProductDot(){
    
    var col1 = document.forms["mForm"]["cols1"].value;
    var row2 = document.forms["mForm"]["row2"].value;
    var prod = document.getElementById("3").checked;
    var dProd = document.getElementById("4").checked;
    
    if(((col1 !== row2) && ((prod) || (dProd))))
        return false;
    else
        return true;   
}
//validates entry of positive integer numbers
function validateNumEntry(x){
    var reg = /^[1-9][0-9]*$/;
    
    return reg.test(x);
    
    
}
//validates entry cells of matrix to match real numbers
function validateCells(x){
    var reg = /^\s*\-?((\d+(\.\d+)?)|(\.\d+))\s*$/;
    return reg.test(x);
}

function randomFill(){
    
   var fElem = document.resultForm.elements.length;
    for(var i = 0; i < fElem-1; i++)
     {
        document.forms["resultForm"].elements[i].value = Math.floor((Math.random() * 20) + 1);
     }
}

function dpRandomFill(){
    var fElem = document.resultForm.elements.length;
    for(var i = 0; i < fElem-3; i++)
     {
        document.forms["resultForm"].elements[i].value = Math.floor((Math.random() * 20) + 1);
     }
}

function validateRegistration()
{
    var fElem = document.login.elements.length;
     for(var i = 0; i < fElem - 1; i++)
     {
         var x = document.forms["login"].elements[i].value;
         if( x==="" || x=== null )
         {
             alert("All fields must be specified before continuing");
             return false;
         }
     }
 }