!function(t,e){"use strict";var r=function(){return new r.init},o=function(t){for(var e={},r=0,o=t.length;o>r;r++)e[t[r].name]=t[r].value;return e};r.prototype={checkAuthorization:function(){if(localStorage.user){var t=JSON.parse(localStorage.user),r=CryptoJS.HmacSHA1(t.idUser+t.secret,t.secret.toString()).toString();e.ajax({type:"GET",url:"api/auth/getSecret",headers:{idUser:t.idUser,hash:r},success:function(t,e,r){window.location.href="theme.html/#/theme"},error:function(t,e,r){window.location.href="/"}})}},registration:function(t){e(".infoAuth").empty(),e.ajax({url:"api/auth/registration",type:"POST",data:{name:t.name,email:t.email,password:t.pass,confirmPassword:t.pass_confirmation,category:t.category},statusCode:{200:function(t,r,o){var a=e(".infoAuth");a.html('<p class="success">Акаунт створено!</p>'),a.slideDown()},415:function(t,r,o){var a=JSON.parse(t.getResponseHeader("error"));e(a).each(function(t,r){var o=e(".infoAuth");o.html('<p class="error">'+r+"</p>"),o.slideDown()})},403:function(t,r,o){var a=e(".infoAuth");a.html('<p class="error">'+o+"</p>"),a.slideDown()}}})},login:function(t){e(".infoAuth").empty(),e.ajax({url:"api/auth/login",type:"PUT",data:{email:t.email,password:t.pass},statusCode:{200:function(t,e,r){var o=JSON.parse(r.getResponseHeader("keys"));o[2];localStorage.user=JSON.stringify({idUser:o[0],secret:o[1]}),window.location.href="theme.html/#/theme"},401:function(t,r,o){var a=e(".infoAuth");a.html('<p class="error">'+o+"</p>"),a.slideDown()},415:function(t,r,o){var a=JSON.parse(t.getResponseHeader("error"));e(a).each(function(t,r){var o=e(".infoAuth");o.html('<p class="error">'+r+"</p>"),o.slideDown()})}}})}},r.init=function(){var t=this;e.validate({modules:"security"}),e("form").on("submit",function(){return!1}),e("input[type=submit]").on("click",function(r){setTimeout(function(){var a=e(r.target).parents("form");a.hasClass("has-error")||("registration"===a.attr("id")?t.registration(o(a.serializeArray())):"login"===a.attr("id")&&t.login(o(a.serializeArray())))},0)})},r.init.prototype=r.prototype,t.uawcapp.Auth=r}(window,jQuery);