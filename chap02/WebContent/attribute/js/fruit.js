const pineapple = document.getElementById('pineapple');
const orange = document.getElementById('orange');
const mango = document.getElementById('mango');

const fruits = document.getElementsByClassName('fruits');


/*Array.from(fruits).forEach((value) => {
	value.addEventListener('click',function () {
		location.href = '/chap02/fruit/controller?fruit=' + value.getAttribute("id");
	})
})*/
//자바스크립트로 GET방식 요청을 보내는 아주 기본적인 방법
Array.from(fruits).forEach((value) => {
	value.addEventListener('click', () => {
		location.href = '/chap02/fruit/controller?fruit=' + value.dataset.fruitName;
	})
})



