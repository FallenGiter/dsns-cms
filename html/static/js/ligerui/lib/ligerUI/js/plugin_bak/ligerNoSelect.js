(function(A){A.fn.ligerNoSelect=function(B){if(B==null){prevent=true}else{prevent=B}if(prevent){return this.each(function(){if(A.browser.msie||A.browser.safari){A(this).bind("selectstart",function(){return false})}else{if(A.browser.mozilla){A(this).css("MozUserSelect","none");A("body").trigger("focus")}else{if(A.browser.opera){A(this).bind("mousedown",function(){return false})}else{A(this).attr("unselectable","on")}}}})}else{return this.each(function(){if(A.browser.msie||A.browser.safari){A(this).unbind("selectstart")}else{if(A.browser.mozilla){A(this).css("MozUserSelect","inherit")}else{if(A.browser.opera){A(this).unbind("mousedown")}else{A(this).removeAttr("unselectable","on")}}}})}}})(jQuery);