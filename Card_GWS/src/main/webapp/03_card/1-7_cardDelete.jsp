<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
if(confirm("삭제하시겠습니까?")){
	alert("삭제되었습니다.");
	opener.parent.location='card?command=card_list';
	window.close();
}
else{
	history.go(-1);
}
</script>
<meta charset="UTF-8">
<title>카드 삭제</title>
</head>
<body>
</body>
</html>