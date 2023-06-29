//노드[node:xml언어] == 태그(tag) == element[요소]
//파라미터를 두 개를 받음
//@param1 - element의 주소번지를 받아옴
//@param2 - 1번을 대신할 문자열 값
function replaceText(el,text){
	if(el !=null){
		//기존의 노드에 들어있는 값은 초기화 시킨다.
		clearText(el);
		const newNode = document.createTextNode(text);
		el.appendChild(newNode);
	}
}//replaceText ended

function clearText(el){
	if(el !=null){
		if(el.childNodes){
		//replaceText(boardsSoldEl, newTotal);
			for(let i=0;i<el.childNodes.length;i++){
				const childNode = el.childNodes[i];
				el.removeChild(childNode);
			}//for ended
		}//if ended
	}//if ended 노드가 널이 아니면
}//clearText ended

//childNodes는 지정된 개체의 직접적인 자식개체인  HTML elements와
//TextNode개체들의 컬렉션을 반환한다.
function getText(el){
	var text = "";
	if(el !=null){
		if(el.childNodes){
			for(let i=0;i<el.childNodes.length;i++){
				const childNode = el.childNodes[i];
				//너 텍스트 노드니?
				if(childNode.nodeValue !=null){
					text = text + childNode.nodeValue;
				}
			}//같은 노드가 n개 있을 때를 위해
		}//
	}//자식 노드가 존재하니?
	return text;
}//getText ended