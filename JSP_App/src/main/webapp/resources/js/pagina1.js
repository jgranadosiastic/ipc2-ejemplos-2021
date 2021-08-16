function fnButton1() {
			var visibility = document.getElementById('p1').style.visibility;
			if (visibility === 'hidden') {
				document.getElementById('p1').style.visibility = 'visible';
			} else {
				document.getElementById('p1').style.visibility = 'hidden';
			}

			document.getElementById('id2').style.color = 'green';
		}
