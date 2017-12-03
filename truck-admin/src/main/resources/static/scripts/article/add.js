var mditor, htmlEditor;
$('#tags').tagsInput({
    width: '100%',
    height: '35px',
    defaultText: '请输入文章标签'
});
$(function(){


    $(".select2").select2({
        width: '100%'
    });

    $("#summernotediv").hide();
    $("#markdowndiv").show();
    mditor = window.mditor = Mditor.fromTextarea(document.getElementById('md-editor'));
    // 富文本编辑器

    // 富文本编辑器
    htmlEditor = $('.summernote').summernote({
        lang: 'zh-CN',
        height: 340,
        placeholder: '写点儿什么吧...',
        //上传图片的接口
        callbacks:{
            onImageUpload: function(files) {
                var data=new FormData();
                data.append('file[0]',files[0]);
                tale.showLoading();
                $.ajax({
                    url: basepath+'/qiniu/upload/image',     //上传图片请求的路径
                    method: 'POST',            //方法
                    data:data,                 //数据
                    processData: false,        //告诉jQuery不要加工数据
                    dataType:'json',
                    contentType: false,        //<code class="javascript comments"> 告诉jQuery,在request head里不要设置Content-Type
                    success: function(result) {
                        tale.hideLoading();
                        if(result && result.success){
                            var url = $('#attach_url').val() + result.payload[0].fkey;
                            console.log('url =>' + url);
                            htmlEditor.summernote('insertImage', url);
                        } else {
                            tale.alertError(result.msg || '图片上传失败');
                        }
                    }
                });
            }
        }
    });


    $('#switch-btn').click(function () {
        var type = $('#fmt_type').val();
        var this_ = $(this);
        if (type == 'markdown') {
            // 切换为富文本编辑器
            mditor.value = '';
            $("#summernotediv").show();
            $("#markdowndiv").hide();
            this_.text('切换为Markdown编辑器');
            $('#fmt_type').val('html');
        } else {
            // 切换为markdown编辑器
            $("#summernotediv").hide();
            $("#markdowndiv").show();
            $('#fmt_type').val('markdown');
            this_.text('切换为富文本编辑器');
            htmlEditor.summernote("code", "");
        }
    });


});

function submitform() {
    var content = $('#fmt_type').val() == 'markdown' ? mditor.value : htmlEditor.summernote('code');
    var title = $('#title').val();
    if (title == '') {
        layer.alert('请输入文章标题');
        return;
    }

    if (!content.trim()) {
        layer.alert('请输入文章内容');
        return;
    }
    $('#content-editor').val(content);

    if($('#multiple-sel').val()){
        $("#categorys").val($('#multiple-sel').val());
    }else{
        $("#categorys").val("1");
    }
    $.ajax({
       type:'post',
       url:basepath+'/article/save', data:$("#form-add").serialize(),
       success:function (data) {
           if(data == 1){
               location.href=basepath+"/article/index";
           }
       }
    });

}
