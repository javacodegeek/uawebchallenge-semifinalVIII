window.uawcapp = {};
$(document).ready(function () {

    //создаю пользовательские объекты
    var style = new uawcapp.Style();
    var widgets = new uawcapp.Widgets();
    var auth = new uawcapp.Auth();

    //проверка заавторизован ли пользователь
    auth.checkAuthorization();

    //скрытие меню редактирование конкретного блока
    $('.template__tabs li').on('click', function () {
        $('[class ^= element__]').hide();
    });

    $('body').on('click', '.hover__buttons li', function (e) {
        var target = $(e.target);
        widgets.modifyPage(target);
    });

    //сохраниение изменений на странице
    $('.page__sheet').on('change', function () {
        var dom = $('.page')[0];
        widgets.savePage(dom.innerHTML);
    });

    //сохранение стилий при изменении
    $('.design').on('change', function () {
        style.saveStyle(style.setStyle($('.design').serializeArray()));
    });

    //сохранение стилий при изменении
    $('.design').on('keyup', function () {
        style.saveStyle(style.setStyle($('.design').serializeArray()));
    });

    /*
    * Скрывает блок входа показывает регистрацю
    */
    var registration = function () {
        $('#registration').show();
        $('#login').hide();
    };

    /*
    * Скрывает блок регистрации показывает вход
    */
    var login = function () {
        $('#registration').hide();
        $('#login').show();
    };

    //Кастомный роутер
    var routing = function () {
        switch (window.location.hash) {
            case '#/registration':
                registration();
                break;
            case '#/login':
                login();
                break;
            case '#/theme':
                window.location.href = 'theme.html';
                break;
            case '#/constructor/1':
                $('.theme__template').hide();
                $('.constructor__block').show();
                break;
            case '':
                break;
            default :
                window.location.href = '/';
        }
    };

    routing();

    $(window).on('hashchange', function () {
        routing();
    });
});