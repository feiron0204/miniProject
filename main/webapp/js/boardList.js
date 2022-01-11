$(function(){
	$.ajax({
		type:'post',
		url:'/miniProject/board/getBoardList.do',
		data:'pg='+$('#pg').val(),
		dataType:'json',
		success:function(data){
			$.each(data.list,function(index,items){
				$('<tr/>')
				.append($('<td/>',{
					align: 'center',
					text:items.seq
				}))
				.append($('<td/>',{
					align: 'center',
				}).append($('<a/>',{
					href:'#',
					text:items.subject,
					class:'subjectA'
				})))
				.append($('<td/>',{
					align: 'center',
					text:items.id
				}))
				.append($('<td/>',{
					align: 'center',
					text:items.logtime
				}))
				.append($('<td/>',{
					align: 'center',
					text:items.hit
				}))
				.appendTo($('#boardListTable'));
				
			});//each
				//로그인 여부
				$('.subjectA').click(function(a){
					console.log($(this).parent().prev().text());
					if(data.memId==null){
					    alert('먼저 로그인 하세요');
					}else{
						location.href='/miniProject/board/boardView.do?seq='+$(this).parent().prev().text()+'&pg='+$('#pg').val();
					}
				});//click
		},
		error:function(err){
			alert(err);
		}
	});
});