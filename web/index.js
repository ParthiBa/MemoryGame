
//var xa =($(".imgbtn").length);
//console.log(x);
// 
var btnpressed=[];
var imgCounter = 0;
	var playername="";


// var url ="http://10.10.1.149:8080/javacatest-master";
 var url ="http://localhost:8080/javacatest-master";

 


$(document).on("pagecontainerbeforeshow", function (_, $ui)
			   {
	//

if("GameList"==$ui.toPage.attr("id")){
     console.log(playername);
   
        
    $("#usernametxt").text(playername);
     $("#listgames").empty();   
    
  var promise = $.getJSON(url+"/api/gameService/getGames");
               promise.done(function (data){
                  for (var i=0, len=data.length; i < len; i++) {
                    $("#listgames").append(createListItem(i,data[i].Name));
                // $("#listgames").listview("refresh");
                     
               }
        $("#listgames").listview("refresh");
               });
}    
    function createListItem(item,value){
      
    var $a = $("<a>").attr("href","#gamescreen");
        $a.text(value);    
    //   var $li = $("<li>").append($a);

         console.log($li);
      
           var $li = $("<li>").append($a);
    return ($li);
        return $a;
    }

    
       if("gamescreen"==$ui.toPage.attr("id"))
     { 
         
         
         $('.imgbtn').empty();
         $("#submit").attr("disabled","");
            $("#reset").attr("disabled","");
  

$('.imgbtn').each(function(i, obj) {
	
	console.log(i);
	console.log($(this));
	picId=i;
		picId++;
     $(this).attr("id","btn"+picId);
	$(this).append(createImg(picId));
	
                                  });


	
	function createImg(name) {
		var $img = $("<img>").attr({"src":"Images/number"+name+".jpg","style": "height:200px; width:150px"});
    	return ($img);
		}
    
    
    //new Game page
        if("newGame"==$ui.toPage.attr("id"))
     {
         
        $("GameName").val("");
     }
	
     }

	
	
	

	
});



$(document).on("pagecontainershow",function(_,$ui)
			   {

  // game list page 
    if("GameList"==$ui.toPage.attr("id")){
        
        

        $('#listgames').on('click', 'li a', function() {
        alert($(this).text()+ "this"); // id of clicked li by directly accessing DOMElement property
    });
        
        
       
        $("#NewGameButton").on("click",function(){
        $.mobile.navigate("#newGame");
        });
    }
	
	if("newPlayer"==$ui.toPage.attr("id")){
        $("#startButton").on("click",function(){

        playername=$("#PlayerName").val();
            console.log(playername);
            console.log("hoiiiqqiqiiqiqqiqiqiiqiqqiiq");
            $.mobile.navigate("#GameList");
        
        });
    }
     if("newGame"==$ui.toPage.attr("id"))
     {    
       $("#GameName").val(""); 
	           $("#GameEnterButton").on("click",function(){
                 var text=$("#GameName").val(); 
    var promise = $.getJSON(url+"/api/gameService/newgame",{"gameName":text});
               promise.done(function (data){
                
                   console.log(111);  
                     if(data.Name==text)
                     {
                         
                     }
                    $.mobile.navigate("#GameList");
                
               });
                   
                
        
               });
               
     }
    
    
    
    
    //// Game Screeen logic
       if("gamescreen"==$ui.toPage.attr("id"))
     { 
         $("#submit").on("click",function(){
//send data		
		  console.log(btnpressed);
             console.log("button pressed");

     });
	
	$("#reset").on("click",function(){
	
   if($(".imgbtn").attr("disabled"))
	{
	$(".imgbtn").removeAttr("disabled");	
	$(".imgbtn").removeAttr("style");	
    $("#submit").attr("disabled","");
	
	}
		imgCounter=0;
	btnpressed=[];
	
	
	});
         
         
        $(".imgbtn").on("click",function(){
	
		//$(this).toggleClass("ongreen");
		//$(this).addClass("ongreen");
				
		// $("this").css("background-color", "yellow");
	    if($(this).attr("style"))
		{
			$(this).removeAttr("style");
			imgCounter--;
				var i = btnpressed.indexOf($(this).attr("id"));
			if(i > -1)
			{
				btnpressed.splice(i,1);
			}
		//
		}
	    else
		{
			imgCounter++;
		$(this).attr("style","background-color:green;");	
				btnpressed.push($(this).attr("id"));
		
		}
		console.log($(this).attr("id"));
		
  		console.log(imgCounter);
				if(imgCounter==2)
				{
					$(".imgbtn").attr("disabled","");
					$("#submit").removeAttr("disabled");
					$("#reset").removeAttr("disabled");
				}
				if(imgCounter==1)
				{
							$("#reset").attr("disabled","");
				}
	});
         
         
         
     }
	
	
	//button on click
	
	
	

	
});