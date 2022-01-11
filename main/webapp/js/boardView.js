$(function(){
	$.ajax({
		type:'post',
		url:'/miniProject/board/getBoardView.do?seq='+$('#seq').val(),
		data:'seq:'+$('#seq').val(),
		dataType:'json',
		success:function(data){
			console.log(data);
				//$('#subjectTd').text(data.boardDTO.subject);
				//$('#seqTd').text(data.boardDTO.seq);
				//$('#idTd').text(data.boardDTO.id);
				//$('#hitTd').text(data.boardDTO.hit);
				//$('#contentTd').html("<pre>"+data.boardDTO.content+"</pre>");
				$('#subjectSpan').text(data.boardDTO.subject);
				$('#seqSpan').text(data.boardDTO.seq);
				$('#idSpan').text(data.boardDTO.id);
				$('#hitSpan').text(data.boardDTO.hit);
				$('#contentSpan').text(data.boardDTO.content);
		},
		error:function(err){
			alert(err);
		}
	});//ajax
	
	
});