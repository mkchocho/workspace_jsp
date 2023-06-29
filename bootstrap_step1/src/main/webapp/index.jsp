<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//response.setIntHeader("Refresh",5);
	String s_id = (String)session.getAttribute("s_id");
	String menu = request.getParameter("menu");
	StringBuilder path = new StringBuilder(request.getContextPath());
	path.append("/");
%>    
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<%@include file="../common/bootstrap_common.jsp"%>
    <link rel="stylesheet" href="../css/style.css?1" />
    <title>구디아카데미</title>
	<script type="text/javascript">
		let zipcodeModal = null;
		function choice(zipcode, address){
			//alert('선택'+zipcode+", "+address);
			$('#mem_zipcode').val(zipcode);
			$('#mem_addr').val(address);
			zipcodeModal.hide();
		}
		function zipcodeSearch(){
			const dong = $('#dong').val();
  			$.ajax({
			      url:'./member/zipcodeList.bs?dong='+dong,
			      success:function(data){
			      	$("#d_zipcode").html(data);
					zipcodeModal = new bootstrap.Modal(document.getElementById('zipcodeModal'));
					zipcodeModal.show();
			      },
			      error:function(e){
			    	  $("#loginForm").text(e.responseText);
			      }
			});			
		}
		function memberUpdateAction(){
    		$("#f_memberUpd").attr('method','get');
    		$("#f_memberUpd").attr('action','./member/memberUpdate.bs');
    		$("#f_memberUpd").submit();			
		}
		function memberUpdateForm(){
			//alert('memberUpdateForm');
			//부트스트랩5에서 모달 스크립트로 열때 사용
			//var myModal = new bootstrap.Modal(document.getElementById('exampleModal2'))
			//myModal.show()
  			$.ajax({
			      //url:'./main/loginAccount.jsp',
			      url:'./member/memberDetail.bs?mem_id=<%=s_id%>',
			      success:function(data){
			        //alert(data);
			        
			        //$("#login").css("display","none");
			      	//console.log("data:"+data);
			      	$("#d_update").html(data);
					const updateModal = new bootstrap.Modal(document.getElementById('updateModal'));
					updateModal.show();
			      },
			      error:function(e){
			    	  $("#loginForm").text(e.responseText);
			      }
			});
			
		}
    	function memberShip(){
    		alert('memberShip호출');
    		$("#f_member").attr('method','get');
    		$("#f_member").attr('action','./member/memberInsert.bs');
    		$("#f_member").submit();
        }	
		function loginAction(){
		    const id = $('#mem_id').val(); 
		    const pw = $('#mem_pw').val(); 
			$.ajax({
			      //url:'./main/loginAccount.jsp',
			      url:'./member/login.bs?mem_id='+id+'&mem_pw='+pw,
			      success:function(data){
			        //alert("11");
			        //$("#login").css("display","none");
			        //console.log("data:"+data);
			          $("#loginForm").html(data);
			      },
			      error:function(e){
			    	  $("#loginForm").text(e.responseText);
			      }
		      });			
    		//const btn_login = document.querySelector('#login');
    		//const f_login = document.querySelector('d-flex');
    		//btn_login.onclick = function(e){
    			//alert(e);
    			//f_login.innerHTML = "test";
  	    		//console.log(e);
    			//e.preventDefault();						
		}
    		
	    function logoutAction(){
	        $.ajax({
	  	      url:'./main/logout.jsp',
	  	      success:function(data){
	  	        //alert("logout:"+data);
	  	        //$("#loginForm").css("display","none");
	  	        //console.log("data:"+data);
	  	          $("#loginForm").html(data);
	  	      },
	  	      error:function(e){
	  	    	  $("#login").text(e.responseText);
	  	      }
	        });
	      }      		
	</script>
  </head>
  <body>
    <!-- ============================== [[ NavBar section]] ==============================-->
    
	<%@ include file="./main/navbar.jsp" %>
	
    <!-- ============================== [[ NavBar section]] ============================== -->
    <%
    	if(menu == null){
    %>
    <!-- ============================= [[ Carousel section]] ============================= -->

	<jsp:include page="./main/carousel.jsp" />

    <!-- ============================= [[ Carousel section]] ============================= -->
    <!-- =============================  [[ Card section ]]  ============================= -->

	<jsp:include page="./main/card.jsp" />

    <!-- =============================  [[ Card section ]]  ============================= -->
    <%
    	}
    	else if("menu1".equals(menu)){
    %>
    <jsp:include page="./page/menu1.jsp" />
    <%
    	}
    	else if("menu2".equals(menu)){
    %>
    <jsp:include page="./page/menu2.jsp" />
 	<%
    	}
    	else if("menu3".equals(menu)){
 	%>
 	<jsp:include page="./page/menu3.jsp" />
 	<%
    	}
 	%>
    <!-- =============================  [[ Footer section ]]  ============================= -->

	<%@ include file="./main/footer.jsp" %>

    <!-- =============================  [[ Footer section ]]  ============================= -->
    
    <!-- =============================  [[ 회원가입 section ]]  ============================= -->    
    
 	<%@ include file="./main/modal/memberShip.jsp" %>
 	
    <!-- =============================  [[ 회원가입 section ]]  ============================= -->    
    
    <!-- =============================  [[ 정보수정 section ]]  ============================= -->    
    <div id="d_update">
    </div>
    <!-- =============================  [[ 정보수정 section ]]  ============================= -->    
    <!-- =============================  [[ 우편번호 찾기 section ]]  ============================= -->    
    <div id="d_zipcode">
    </div>
    <!-- =============================  [[ 우편번호 찾기 section ]]  ============================= -->    
    
  </body>
</html>
