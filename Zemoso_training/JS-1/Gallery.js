data.images.forEach( function(obj) {
	 	var img = new Image();
  		img.src = obj.img;
  		img.setAttribute("class", "banner-img");
  		img.setAttribute("alt", "effy");
  		document.getElementById("img-container").appendChild(img);	
		});

		var add = document.getElementById("add");
		add.onclick=function()
		{	
			var Url = prompt("Enter the image url");
			var re = /^(http[s]?:\/\/){0,1}(www\.){0,1}[a-zA-Z0-9\.\-]+\.[a-zA-Z]{2,5}[\.]{0,1}/;
				if (!re.test(Url))
				{ 
    			alert("Enter Valid Url");
    			return false;
    			}
  			var Name = prompt("Enter the name of the Image");
  			if(Name == "" || Name == null)
    		{
    			alert("name con't be empty") ; return false ;
    		}
 		 	var date = new Date();
  			date = prompt('Enter todays Date' , "yyyy/mm/dd");
  			var datestamp = new Date();
  			var present = datestamp.getFullYear()+'/'+(datestamp.getMonth()+1)+'/'+datestamp.getDate();
  			if(date > present)
  			{
  				alert("Date cannot be in future")
  			}

  			var Information = prompt("Enter the Info about the Image");	
  			if( Information =="" || Information == null)
    		{
    			alert("Info cannot be empty");
    		}
  			data.images.push({"img": Url , "name":Name , "date" :date, "info" : Information});
  			var img = new Image();
  			img.src = data.images[data.images.length -1].img;
  			document.getElementById("img-container").appendChild(img);
			}

			var edit = document.getElementById("edit");
			edit.onclick = function()
			{
  			var id = prompt("Image id 1-10");
  			var Url = prompt("Enter the new Url");
  			var Name = prompt("Enter the new Name");
  			var Info = prompt("Enter the new Info");
  			var date = prompt("Enter todays Date" , "yyyy/mm/dd");
  			var list = document.getElementById("img-container").getElementsByTagName("img");
  			list[id-1].setAttribute("src" , Url);
  
			}
  			var del = document.getElementById("del");
  			del.onclick = function()
  			{
  				var id = prompt("enter the id");
  				var list = document.getElementById("img-container").getElementsByTagName("img");
  				document.getElementById('img-container').removeChild(list[id-1]);
  			}
  		



