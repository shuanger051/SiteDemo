 /*弹框JS内容*/
    jQuery(document).ready(function($){
        //打开窗口
        $('.cd-popup-trigger0').on('click', function(event){
            event.preventDefault();
            $('.cd-popup').addClass('is-visible');
            //$(".dialog-addquxiao").hide()
        });
        //关闭窗口
        $('.cd-popup').on('click', function(event){
            if( $(event.target).is('.cd-popup-close') || $(event.target).is('.cd-popup,.code_body') ) {
                event.preventDefault();
                $(this).removeClass('is-visible');
            }
        });
        //ESC关闭
        $(document).keyup(function(event){
            if(event.which=='27'){
                $('.cd-popup').removeClass('is-visible');
            }
        });
		
		//打开窗口
        // $('.cd-popup-trigger1,.cd-popup-trigger2').on('click', function(event){
         //    event.preventDefault();
         //    $('.cd-popup1').addClass('is-visible1');
         //    //$(".dialog-addquxiao").hide()
        // });
        // //关闭窗口
        // $('.cd-popup1').on('click', function(event){
         //    if( $(event.target).is('.cd-popup-close') || $(event.target).is('.cd-popup1') ) {
         //        event.preventDefault();
         //        $(this).removeClass('is-visible1');
         //    }
        // });
        //ESC关闭
        // $(document).keyup(function(event){
        //     if(event.which=='27'){
        //         $('.cd-popup1').removeClass('is-visible1');
        //     }
        // });
        //
        // //打开窗口
        // $('.cd-popup-trigger2').on('click', function(event){
        //     event.preventDefault();
        //     $('.cd-popup2').addClass('is-visible2');
        //     //$(".dialog-addquxiao").hide()
        // });
        // //关闭窗口
        // $('.cd-popup2').on('click', function(event){
        //     if( $(event.target).is('.cd-popup-close') || $(event.target).is('.cd-popup2') ) {
        //         event.preventDefault();
        //         $(this).removeClass('is-visible2');
        //     }
        // });
        // //ESC关闭
        // $(document).keyup(function(event){
        //     if(event.which=='27'){
        //         $('.cd-popup2').removeClass('is-visible2');
        //     }
        // });
        //
        // //打开窗口
        // $('.cd-popup-trigger3').on('click', function(event){
        //     event.preventDefault();
        //     $('.cd-popup3').addClass('is-visible3');
        //     //$(".dialog-addquxiao").hide()
        // });
        // //关闭窗口
        // $('.cd-popup3').on('click', function(event){
        //     if( $(event.target).is('.cd-popup-close') || $(event.target).is('.cd-popup3') ) {
        //         event.preventDefault();
        //         $(this).removeClass('is-visible3');
        //     }
        // });
        // //ESC关闭
        // $(document).keyup(function(event){
        //     if(event.which=='27'){
        //         $('.cd-popup3').removeClass('is-visible3');
        //     }
        // });
    });