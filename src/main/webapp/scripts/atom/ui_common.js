$(function() {
  multiSelectLoad();
  checkboxAll(); 
  datetimeLoad(); 
  gnbViewAll();
  textClear();
  colorLoad();
  formBlurDrag(); // drag 영역안에 dropdown form 요소가 있는 경우 사용
  $(window).add('div').on('scroll', function() {
    multiSelectReposition();
    tagsInputPosition();
    formBlur();
  });
  $('.gnb_menu_wrap .dep_01').hover(formBlur);
}); 
$(window).on('resize', function() {
  multiSelectReposition();
  tagsInputPosition();
});


/* form: Multiselect load */
function multiSelectLoad() {
  var $multiselect = $('.select > select');
  for (var i = 0; i < $multiselect.length; i++) {
    var $multiselect_wrap = $multiselect.eq(i).parent('.select');
    if($multiselect_wrap.hasClass('select_all')&&$multiselect_wrap.hasClass('search')){
      $multiselect.eq(i).multiselect({
        includeSelectAllOption: true,
        enableFiltering: true,
        enableCaseInsensitiveFiltering: true
      });
    }else if($multiselect_wrap.hasClass('select_all')){
      $multiselect.eq(i).multiselect({
        includeSelectAllOption: true
      });
    }else if($multiselect_wrap.hasClass('search')){
      $multiselect.eq(i).multiselect({
        enableFiltering: true,
        enableCaseInsensitiveFiltering: true
      });
    }else{
      $multiselect.eq(i).multiselect({
        // includeSelectAllOption: true
      });
    }
  }
  var $btn_toggle =  $('.multiselect.dropdown-toggle');
  for (var i = 0; i < $btn_toggle.length; i++) {
    $btn_toggle.eq(i).off();
    $btn_toggle.eq(i).on('click', function() {
      multiSelectPosition($(this));
    });
  }
}
function multiSelectPosition(e) {
  var $container = e.next('.multiselect-container'),
      $scroll_top = (document.documentElement && document.documentElement.scrollTop) || document.body.scrollTop,
      $scroll_left = (document.documentElement && document.documentElement.scrollLeft) || document.body.scrollLeft,
      $top = e.offset().top - $scroll_top + e.outerHeight(),
      $left = e.offset().left - $scroll_left;
  $container.css({
    minWidth : $(e).outerWidth()
  });
  if($(window).height() < $top + $container.outerHeight()){
    $container.css({
      top : $top - $container.outerHeight() - e.outerHeight(), 
      left : $left
    });
  }else{
    $container.css({
      top : $top, 
      left : $left
    });
  };
  if($(window).width() < $left + $container.outerWidth()){
    $container.css({
      left : $left - $container.outerWidth() + $container.parent('.btn-group').outerWidth(), 
    });
  };
}
function multiSelectReposition() {
  if($('.select').find('.btn-group').hasClass('open')){
    multiSelectPosition($('.btn-group.open').find('.multiselect.dropdown-toggle'));
  }
}

/* form: Datetime picker load */
function datetimeLoad() {
  // datetime insert button icon
  var $dateclock = $('.input.datetime,.input.datetime_s,.input.date,.input.time,.input.time_s');
  for (var i = 0; i < $dateclock.length; i++) {
    if ($dateclock.eq(i).find('.btn').length == 0) {
      $dateclock.eq(i).append('<i class="btn"></i>')
    }
  }
  // picker load
  if ($('.input.datetime').length > 0) {
    $('.input.datetime').datetimepicker({
      useCurrent: true,
      // locale: 'ko',
      format: 'YYYY-MM-DD HH:mm',
      defaultDate: new Date(),
      allowInputToggle: true,
      sideBySide: true,
      showTodayButton: true,
      //showClear: true,
      showClose: true,
      toolbarPlacement: 'bottom',
      ignoreReadonly: true,
      // focusOnShow: false,
      widgetParent: 'body'
    });
  }
  if ($('.input.datetime_s').length > 0) {
    $('.input.datetime_s').datetimepicker({
      useCurrent: true,
      // locale: 'ko',
      format: 'YYYY-MM-DD HH:mm:ss',
      defaultDate: new Date(),
      allowInputToggle: true,
      sideBySide: true,
      showTodayButton: true,
      //showClear: true,
      showClose: true,
      toolbarPlacement: 'bottom',
      ignoreReadonly: true,
      // focusOnShow: false,
      widgetParent: 'body'
    });
  }
  if ($('.input.date').length > 0) {
    $('.input.date').datetimepicker({
      useCurrent: true,
      // locale: 'ko',
      format: 'YYYY-MM-DD',
      defaultDate: new Date(),
      allowInputToggle: true,
      sideBySide: true,
      showTodayButton: true,
      //showClear: true,
      showClose: true,
      toolbarPlacement: 'bottom',
      ignoreReadonly: true,
      // focusOnShow: false,
      widgetParent: 'body'
    });
  }
  if ($('.input.time').length > 0) {
    $('.input.time').datetimepicker({
      useCurrent: true,
      // locale: 'ko',
      format: 'HH:mm',
      defaultDate: new Date(),
      allowInputToggle: true,
      sideBySide: true,
      showTodayButton: true,
      //showClear: true,
      showClose: true,
      toolbarPlacement: 'bottom',
      ignoreReadonly: true,
      // focusOnShow: false,
      widgetParent: 'body'
    });
  }
  if ($('.input.time_s').length > 0) {
    $('.input.time_s').datetimepicker({
      useCurrent: true,
      // locale: 'ko',
      format: 'HH:mm:ss',
      defaultDate: new Date(),
      allowInputToggle: true,
      sideBySide: true,
      showTodayButton: true,
      //showClear: true,
      showClose: true,
      toolbarPlacement: 'bottom',
      ignoreReadonly: true,
      // focusOnShow: false,
      widgetParent: 'body'
    });
  }
  // popup:z-index, Delete selected year(period)
  $dateclock.on('dp.show', function() {
    var $datetime = $('.datetime,.datetime_s,.date,.time,.time_s');
    $datetime.removeClass('active');
    $(this).addClass('active');
    $(".datepicker-years .table-condensed thead tr th:eq(1)").removeAttr("data-action");
    $(".datepicker-years .table-condensed thead tr th:eq(1)").css("cursor", "default");
    getCalendarNewDate();
  });
}
// Date Picker - Setting the current date
function getCalendarNewDate() {
  $(".bootstrap-datetimepicker-widget").find(".glyphicon-screenshot").parent("a").click(function(){
    var $activeInput = $(".input.datetime.active,.input.datetime_s.active,.input.date.active,.input.time.active,.input.time_s.active").find("input"); 
    var param = new Object();
    if($activeInput.attr("id") == "startDateTime"){
      param.period = "startDateTime";
    } else if($activeInput.attr("id") == "endDateTime"){
      param.period = "endDateTime";
    } else {
      param.period = "";
    }
    //console.log(param.period);
    var result = $.ajax({
      url : "/atom/common/getCalendarNewDate",
      data : param,
      type : "POST",
      cache : false
    });
    result.done(function(data) {
      $(".input.datetime.active,.input.datetime_s.active,.input.date.active,.input.time.active,.input.time_s.active").data("DateTimePicker").date(data);
    });
    result.fail(function(xhr, status) {
      console.log("getCalendarNewDate - Fail");
    });
    if (result !== null) result = null;
  });
}

/* form: Color picker load */
function colorLoad() {
  var $color = $('.input.color');
  if ($color.length > 0) {
    $color.colorpicker({
      component: '.color_box',
      useAlpha: false,
      horizontal: true,
      extensions: []
    });
  }
  $color.find('input').on('click', function() {
    $(this).parent($color).data('colorpicker').show();
  });
  $color.on('colorpickerShow', function(){
    $(this).find('input').focus();
  });
}

/* form focus out [scroll, drag : z-index, position issue]: multi select, date+time picker, color picker */
function formBlur() {
  var $selectbox = $('.btn-group.open .dropdown-toggle'),
      $datetimebox = $('.input.datetime .btn.active,.input.datetime_s .btn.active,.input.date .btn.active,.input.time .btn.active,.input.time_s .btn.active'),
      $colorbox = $('.input.color'),
      $tagsinputbox = $(".tt-menu.tt-open");
  if($selectbox.length > 0){
    $selectbox.dropdown('toggle'); 
  }
  if($datetimebox.length > 0){
    $datetimebox.parent('.input').datetimepicker('hide');
  }
  if($colorbox.length > 0){
    $colorbox.find('input').blur();
    $colorbox.colorpicker('hide');
  }
  if($tagsinputbox.length > 0){
    $('.tags_input input').typeahead('close');
  }
}
function formBlurDrag() {
  $(".pop_head").on('mousedown', formBlur);
  $(".btn.icon .drag_updown").on('mousedown', formBlur);
}

/* form: Checkbox all toggle */
function checkboxAll() {
	  $('body').on('click', function(e) {
	    var $target = $(e.target);
	    var $nodeName = e.target.nodeName;
	    if ($target.parent().hasClass('checkbox') && $nodeName == 'INPUT') {
	      if ($target.hasClass('all')) {
	        var $checkbox = $target.parents('.checkbox_all').find('.checkbox').find('input').not('.all');
	        if ($target.is(':checked')) {
	          $checkbox.prop('checked', true);
	        } else {
	          $checkbox.prop('checked', false);
	        }
	      } else {
	    	  // child checkbox 
	        var $checkbox_all = $target.parents('.checkbox_all').find('.checkbox').find('input.all');
	        if (!$target.is(':checked')) {
	          $checkbox_all.prop('checked', false);
	        }
	        else {
	        	// all check 안되어 잇으나 child checkbox모두 체크되어 all도 자동으로 체크 되게 할 것. 20190715
	        	if ($target.parents('.checkbox_all').find('.checkbox').find('input[type=checkbox]:checked').not('.all').length
			    			== $target.parents('.checkbox_all').find('.checkbox').find('input[type=checkbox]').not('.all').length) {
		    		$checkbox_all.prop('checked', true);
		    	}
	        }
	      }
	    }
	  });
	}


/* form: input text clear */
function textClear() {
  var $input = $('.input.search');
  var $btn_clear = $input.find('.btn.icon');
  $btn_clear.on('click', function(){
    if($(this).find('.clear').length>0){
      $(this).parent('.input').find('input').val('');
    }
  }); 
}

/* gnb: View full menu */
function gnbViewAll() {
  var $body = $('body'),
      $btn_view_all = $('.header .view_all a'),
      $btn_close_all = $('.header .btn.close_all');
  $btn_close_all.on('click', function(){
    $body.removeClass('gnb_view_all');
  }); 
  $btn_view_all.on('click', function(){
    $body.addClass('gnb_view_all');
  }); 
}

/* Side menu (show/hide) */ 
function LayoutToggle() {
  var $layout = $('.cell.type_04');
  var $btn_toggle = $layout.find('.btn.icon.toggle');
  $btn_toggle.on('click', function(){
    var $cell = $btn_toggle.parents('.cell');
    if($cell.hasClass('on')){
      $btn_toggle.attr('title','Show').find('i').removeClass().addClass('arrow_right');
      $cell.removeClass('on');
    }else{
      $btn_toggle.attr('title','Hide').find('i').removeClass().addClass('arrow_left');
      $cell.addClass('on');
    }
  }); 
}

/* Tags Input Position */
function tagsInputTypeahead() {
  $('.tags_input input').on('typeahead:render', function () {
    tagsInputPosition();
  });
  $('.tags_input input').on('click', function (e) {
    $tagsinputTarget = $(e.currentTarget);
  });
}
var $tagsinputTarget;

function tagsInputPosition() {
  if($tagsinputTarget === null || $tagsinputTarget === undefined){
    return;
  }
  var $tt_input = $tagsinputTarget,
      $tt_menu = $tt_input.siblings('.tt-menu'),
      $tt_input_left = $tt_input.offset().left,
      $tt_input_top = $tt_input.offset().top,
      $tt_menu_wid = $tt_menu.outerWidth(),
      $scroll_top = (document.documentElement && document.documentElement.scrollTop) || document.body.scrollTop,
      $scroll_left = (document.documentElement && document.documentElement.scrollLeft) || document.body.scrollLeft,
      $top = $tt_input_top - $scroll_top + $tt_input.outerHeight(),
      $left = $tt_input_left - $scroll_left,
      $result01 = $(window).height() < $top + $tt_menu.outerHeight(),
      $result02 = $(window).width() < $tt_input_left + $tt_menu_wid;
      // console.log($scroll_top);
  if($result01) {
    $tt_menu.css({
      position: 'fixed',
      top: $top - $tt_menu.outerHeight() - $tt_input.outerHeight(), 
      left: $tt_input_left - 4 - $scroll_left,
      right: 'unset'
    });
  } else {
    $tt_menu.css({
      position: 'fixed',
      top: $tt_input_top + 33 - $scroll_top,
      left: $tt_input_left - 4 - $scroll_left,
      right: 'unset'
    });
  };
  if($result02) {
    $tt_menu.css({
      left: 'auto',
      right: $(window).width() - $tt_input.parents('.bootstrap-tagsinput').offset().left - $tt_input.parents('.bootstrap-tagsinput').outerWidth()
    });
  }
}
function tagsInputReposition(e) {
  if($(".tt-menu.tt-open")){
    tagsInputPosition(e);
  }
}

/* Help tooltip */
function helpTooltip() {
  $('.table .help').mouseover(function (e) {
    // console.log(e);
    var $th_hover = $(e.currentTarget),
        $help_dropdown = $th_hover.find('.help_dropdown'),
        $th_left = $th_hover.offset().left,
        $th_top = $th_hover.offset().top,
        $help_wid = $help_dropdown.outerWidth(),
        $scroll_top = (document.documentElement && document.documentElement.scrollTop) || document.body.scrollTop,
        $top = $th_top - $scroll_top - $help_dropdown.outerHeight(),
        $result01 = $(window).width() < $th_left + $help_wid;
    if($result01) {
      $help_dropdown.css({
        left: 'unset',
        right: '30px',
        top: $top,
      });
    } else {
      $help_dropdown.css({
        left: $th_left - 10,
        right: 'unset',
        top: $top,
      });
    };
    $th_hover.addClass('tooltip');
  });
  $('.table .help').mouseout(function (e) {
      $(e.currentTarget).removeClass('tooltip');
  });
  $(document).on('scroll', function() {
    var $help_hover = $('.table .help.tooltip');
    if($help_hover.length > 0){
      console.log("test");
      $help_hover.removeClass('tooltip'); 
    }
  });
}
