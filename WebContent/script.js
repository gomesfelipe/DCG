$(".sendmess").click(function() {
	$(".bar").css("animationName", "send");
	SendMess();
})

function SendMess() {
	setTimeout(function() {
		$(".l1").css("display", "none");
		$(".l2").css("display", "none");
		$(".mailinput").css("display", "none");
		$(".messtxt").css("display", "none");
		$(".sendmess").css("display", "none");

		$(".success").css("display", "inline");
		$(".closemess").css("display", "inline");
	}, 1500);
}

$(".closemess").click(function() {
	$(".bar").css("animationName", "none");
	$(".l1").css("display", "inline");
	$(".l2").css("display", "inline");
	$(".mailinput").css("display", "inline");
	$(".messtxt").css("display", "inline");
	$(".sendmess").css("display", "inline");

	$(".success").css("display", "none");
	$(".closemess").css("display", "none");
	
	$(".mailinput").val("");
	$(".messtxt").val("");
})

$(document)
    .one('focus.messtxt', 'textarea.messtxt', function(){
        var savedValue = this.value;
        this.value = '';
        this.baseScrollHeight = this.scrollHeight;
        this.value = savedValue;
    })
    .on('input.messtxt', 'textarea.messtxt', function(){
        var minRows = this.getAttribute('data-min-rows')|0, rows;
        this.rows = minRows;
        rows = Math.ceil((this.scrollHeight - this.baseScrollHeight) / 16);
        this.rows = minRows + rows;
    });


function findEmoji () {
  window.fetch(`https://emoji.getdango.com/api/emoji?q=${encodeURI(messtxt.value)}`)
    .then(response => response.json())
    .then(json => handleResult(json.results))
    .catch(error => console.error(error.message))
}

function handleResult (items) {
    result.innerHTML = ''
    if (!items) return
    items.length = 7
    items.forEach(item => {
      const button = createEmojiButton(item.text)
      result.appendChild(button);
    })
}

function createEmojiButton(value) {
  const element = document.createElement('button')
  element.classList.add('button')
  element.value = element.innerHTML = value
  element.addEventListener('click', evt => {
    input.value = `${messtxt.value} ${evt.currentTarget.value}`
    input.focus()
  })
  return element
}

findEmoji()