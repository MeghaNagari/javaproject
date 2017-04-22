$(document).ready(function(){
	 var path="/petlove/resources/images/";  
  $("#productstable").DataTable({
	
	  "ajax": {
		    "url": "http://localhost:9109/petlove/admin/adminproducts/all",
		    "dataSrc": ""
		  },
	  "columns": [
          { "data": "prodName" },
          { "data": "",
        	"render":function(data,type,row)
        	{
        	  return "&#8360;."+row.prodPrice+"";
          }  
          
          },
          { "data":"quantity" },
          
          {data:"prodName",
        	  mRender:function(data,type,row){
        		  return '<img src="'+path+data+'.jpg" width="25px" height="25px"></img>';
        	  }
          },
          
          {"data":"productId",
        	  "render":function(data,type,row){
        		  return "<a href='http://localhost:9109/petlove/admin/"+row.productId+"/editproduct' class='btn btn-primary'>Edit</a>";
        	  }
          },
        	
         {"data":"",
        	  "render":function(data,type,row){
        		  return "<a href='http://localhost:9109/petlove/admin/"+row.productId+"/deleteproduct' class='btn btn-primary'>Delete</a>";
        	  }
          }  
                    
      ]
  });
    
    
});