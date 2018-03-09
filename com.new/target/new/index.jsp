<!DOCTYPE html>
<html>
<title>Add</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<div class="w3-container">
  <br/><br/>
 
  <button onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-black">add products</button>

  <div id="id01" class="w3-modal">
    <div class="w3-modal-content">
      <header class="w3-container w3-teal"> 
        <span onclick="document.getElementById('id01').style.display='none'" 
        class="w3-button w3-display-topright">&times;</span>
        <h2>enter over here</h2>
      </header>
     <div align="center" class="modal-content">
   <br/>
    
  <input type="text" onfocus="this.value=''" value="Name"><br/>
   
    <input type="text" onfocus="this.value=''" value="Mobile"><br/>
    <input type="text" onfocus="this.value=''" value="E-mail"><br/>
   
    <button type="button" >add</button>
    
  </div>
  <br/>
      <footer class="w3-container w3-teal">
        <p><button onclick="document.getElementById('id01').style.display='none'">close</button></p>
      </footer>
    </div>
  </div>
</div>
            
</body>
</html>
