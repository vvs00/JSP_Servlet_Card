function open_win(url, name) {
		window.open(url, name,"width=1000, height=1000");
	}
	
function close_win() {
		window.close();
	}


function card_delete() {
    
	alert("삭제되었습니다.");
    opener.parent.location='card?command=card_delete';
    window.close();
}

function cardCheck(){
if(document.frm.name.value.length == 0){
    alert("카드 이름을 입력하세요.");
    return false;
}
if(document.frm.benefits.value.length == 0){
    alert("해택을 입력하세요.");
    return false;
}
return true;
}

function list(){
	history.go(-1);
}

