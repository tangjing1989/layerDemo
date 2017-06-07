/*****************************************************************
 jQuery Ajax封装通用类 (linjq)
 *****************************************************************/
$(function () {
    layui.use(['layer'], function () {
        var layer = layui.layer;
    });
    /**
     * ajax封装
     * url 发送请求的地址
     * data 发送到服务器的数据，数组存储，如：{"date": new Date().getTime(), "state": 1}
     * async 默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
     * 注意，同步请求将锁住浏览器，用户其它操作必须等待请求完成才可以执行。
     * type 请求方式("POST" 或 "GET")， 默认为 "GET"
     * dataType 预期服务器返回的数据类型，常用的如：xml、html、json、text
     * successfn 成功回调函数
     * errorfn 失败回调函数
     */
    jQuery.ax = function (url, data, async, type, dataType, successfn, errorfn) {
        async = (async == null || async == "" || typeof(async) == "undefined") ? "true" : async;
        type = (type == null || type == "" || typeof(type) == "undefined") ? "post" : type;
        dataType = (dataType == null || dataType == "" || typeof(dataType) == "undefined") ? "json" : dataType;
        data = (data == null || data == "" || typeof(data) == "undefined") ? {"date": new Date().getTime()} : data;
        $.ajax({
            type: type,
            async: async,
            data: data,
            url: url,
            dataType: dataType,
            success: function (d) {
                successfn(d);
            },
            error: function (e) {
                errorfn(e);
            }
        });
    };
    /**
     * ajax封装
     * url 发送请求的地址
     * data 发送到服务器的数据，数组存储，如：{"date": new Date().getTime(), "state": 1}
     * successfn 成功回调函数
     */
    jQuery.axpost = function (url, data, successfn) {
        data = (data == null || data == "" || typeof(data) == "undefined") ? {"date": new Date().getTime()} : data;
        $.ajax({
            type: "post",
            data: data,
            url: url,
            dataType: "json",
            traditional: true,//这里设置为true
            success: function (d) {
                successfn(d);
            }
        });
    };
    /**
     * ajax封装
     * url 发送请求的地址
     * data 发送到服务器的数据，数组存储，如：{"date": new Date().getTime(), "state": 1}
     * dataType 预期服务器返回的数据类型，常用的如：xml、html、json、text
     * successfn 成功回调函数
     * errorfn 失败回调函数
     */
    jQuery.axspost = function (url, data, successfn, errorfn) {
        var i;
        // data = (data==null || data=="" || typeof(data)=="undefined")? return break: data;
        $.ajax({
            type: "post",
            data: data,
            url: url,
            dataType: "json",
            success: function (d) {
                successfn(d);
            },
            error: function (e) {
                errorfn(e);
            }
        });
    };

    /**
     * ajax封装
     * url 发送请求的地址
     * data 发送到服务器的数据，数组存储，如：{"date": new Date().getTime(), "state": 1}
     * dataType 预期服务器返回的数据类型，常用的如：xml、html、json、text
     * successfn 成功回调函数
     * errorfn 失败回调函数
     */
    jQuery.axspostWithLaod = function (url, data, successfn, errorfn) {
        var i;
        // data = (data==null || data=="" || typeof(data)=="undefined")? return break: data;
        $.ajax({
            type: "post",
            data: data,
            url: url,
            dataType: "json",
            beforeSend: function () {
                i = ityzl_SHOW_LOAD_LAYER();
            },
            success: function (d) {
                ityzl_CLOSE_LOAD_LAYER(i);
                ityzl_SHOW_TIP_LAYER();
                successfn(d);
            },
            error: function (e) {
                ityzl_CLOSE_LOAD_LAYER(i);
                errorfn(e);
            }
        });
    };
    /*弹出层*/
    /*
     参数解释：
     title	标题
     url		请求的url
     id		需要操作的数据id
     w		弹出层宽度（缺省调默认值）
     h		弹出层高度（缺省调默认值）
     */
    parant_layer_show = function (title, url, w, h, data) {
        if (title == null || title == '') {
            title = false;
        }
        ;
        if (url == null || url == '') {
            url = "404.html";
        }
        ;
        if (w == null || w == '') {
            w = 800;
        }
        ;
        if (h == null || h == '') {
            h = ($(window).height() - 50);
        }
        ;
        if (data == null || data == '') {
            data = '';
        }
        ;
        window.parent.layer.open({
            type: 2,
            area: [w + 'px', h + 'px'],
            fix: false, //不固定
            maxmin: true,
            shade: 0.4,
            data: data,
            title: title,
            content: url
        });
    }
    /*弹出层 参数解释：
     title	标题
     url		请求的url
     id		需要操作的数据id
     w		弹出层宽度（缺省调默认值）
     h		弹出层高度（缺省调默认值）
     */
    parant_layer_show = function (title, url, w, h, data) {
        if (title == null || title == '') {
            title = false;
        }
        ;
        if (url == null || url == '') {
            url = "404.html";
        }
        ;
        if (w == null || w == '') {
            w = 800;
        }
        ;
        if (h == null || h == '') {
            h = ($(window).height() - 50);
        }
        ;
        if (data == null || data == '') {
            data = '';
        }
        ;
        window.parent.layer.open({
            type: 2,
            area: [w + 'px', h + 'px'],
            fix: false, //不固定
            maxmin: true,
            shade: 0.4,
            data: data,
            title: title,
            content: url
        });
    }

    /*关闭弹出框口*/
    parant_layer_close = function () {
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
    }

    layer_show = function (title, url, w, h, data) {
        if (title == null || title == '') {
            title = false;
        }
        ;
        if (url == null || url == '') {
            url = "404.html";
        }
        ;

        var index = layer.open({
            type: 2,
            area: [w + 'px', h + 'px'],
            fix: false, //不固定
            maxmin: true,
            shade: 0.4,
            data: data,
            resize: true,
            title: title,
            content: url
        });
        if (h == null || h == '' || data == null || data == '') {
            layer.full(index);
        }
    }

    /*关闭弹出框口*/
    layer_close = function () {
        var index = parent.layer.getFrameIndex(window.name);
        layer.close(index);
    }


    // layui.use(['layer', 'form', 'laydate'], function () {
    //     var $ = layui.jquery,
    //         form = layui.form(),
    //         laydate = layui.laydate;
    //     //全选
    //     form.on('checkbox(allChoose)', function (data) {
    //         var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]');
    //         child.each(function (index, item) {
    //             item.checked = data.elem.checked;
    //         });
    //         form.render('checkbox');
    //     });
    //
    // });


    function ityzl_SHOW_LOAD_LAYER() {
        layui.use(['layer'], function () {
            var layer = layui.layer;
            return layer.msg('努力中...', {
                icon: 16,
                shade: [0.5, '#393D49'],
                scrollbar: false,
                offset: '0px',
                time: 100000
            });


        });
    }

    function ityzl_CLOSE_LOAD_LAYER(index) {
        layer.close(index);

    }

    function ityzl_SHOW_TIP_LAYER() {
        layer.msg('恭喜您，加载完成！', {time: 1000, offset: '10px'});

    }


    /**
     * 页面初始化加载时以及查询后重新渲染checkbox
     */
    init = function () {
        layui.use(['form', 'layer', 'laypage'], function () {
            var $ = layui.jquery,
                form = layui.form(); //只有执行了这一步，部分表单元素才会修饰成功
            form.render('checkbox');

            //全选
            form.on('checkbox(allChoose)', function (data) {
                var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]');
                child.each(function (index, item) {
                    item.checked = data.elem.checked;
                });
                form.render('checkbox');
            });

        });
    }


    /**
     * 查询封装
     * @param urlAshx 访问地址
     * @param curr    当前页
     * @param dataMap 传参
     * @param noteId  区域页面显示ID
     * @param pageId  区域分页显示ID
     * @param initFunction 初始化方法(处理表单的复选框不出现的问题)
     */
    queryPackage = function (urlAshx, curr, dataMap, noteId, pageId) {
        init();
        $.axspost(urlAshx, {//参数
            paramMap: dataMap,
            page: curr || 1,//向服务端传的参数，此处只是演示
            nums: 10//每页显示的条数
        }, function (datajson) {//成功执行的方法
            if (datajson != null) {
                var norice_content = "";
                // $(datajson.datas).each(function (n, Row) {
                //     norice_content += "<tr>";
                //     norice_content += "<td><input type='checkbox' name='' lay-skin='primary'></td>";
                //     for (var item in Row) {
                //         norice_content += "<td>" + Row[item] + "</td>"
                //     }
                //     norice_content += "</tr>";
                // });
                // $('#' + noteId).html(norice_content);//以html的形式填充数据区域

                var gettpl = document.getElementById('templete').innerHTML;
                layui.laytpl(gettpl).render(datajson, function (html) {
                    document.getElementById('view').innerHTML = html;
                });
                init();
                layui.laypage({
                    cont: pageId,//容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
                    pages: datajson.pages,//总页数
                    skip: true, //是否开启跳页
                    skin: '#AF0000',//分页页数选中的背景色
                    curr: datajson.page || 1, //当前页,
                    jump: function (obj, first) {//触发分页后的回调
                        if (datajson.totalNums != 0) {
                            var oPNode = document.getElementById(pageId);//获取p节点的对象
                            var node = document.createElement('span');//创建一个文本节点
                            // node.setAttribute("class","layui-laypage-total");
                            node.innerHTML = "总条数:" + datajson.totalNums + "条";
                            if (oPNode.firstElementChild != null)
                                oPNode.firstElementChild.appendChild(node);//将创建的文本内容插入到p节点中，追加方式

                        }
                        else
                            document.getElementById(pageId).innerHTML = '没有数据';
                        //$('pageId').html('看看URL的变化。通过hash，你可以记录当前页。当前正处于第'+obj.curr+'页');
                        if (!first) {//点击跳页触发函数自身，并传递当前页：obj.curr
                            queryPackage(urlAshx, obj.curr, dataMap, noteId, pageId)
                        }
                    }
                })
            }
        });
    }



    /**
     * 查询封装 (mybatis-plus版)
     * @param urlAshx 访问地址
     * @param curr    当前页
     * @param dataMap 传参
     * @param noteId  区域页面显示ID
     * @param pageId  区域分页显示ID
     * @param initFunction 初始化方法(处理表单的复选框不出现的问题)
     */
    queryPackageNew = function (urlAshx, curr, dataMap, noteId, pageId) {
        init();
        var page = new Object();
        page.Pagination.current = curr || 1,//向服务端传的参数，此处只是演示
         page.Pagination.size =10//每页显示的条数
        $.axspost(urlAshx, {//参数
            paramMap: dataMap,
            page : JSON.stringify(page),//向服务端传的参数，此处只是演示
        }, function (datajson) {//成功执行的方法
            if (datajson != null) {
                var norice_content = "";
                // $(datajson.datas).each(function (n, Row) {
                //     norice_content += "<tr>";
                //     norice_content += "<td><input type='checkbox' name='' lay-skin='primary'></td>";
                //     for (var item in Row) {
                //         norice_content += "<td>" + Row[item] + "</td>"
                //     }
                //     norice_content += "</tr>";
                // });
                // $('#' + noteId).html(norice_content);//以html的形式填充数据区域

                var gettpl = document.getElementById('templete').innerHTML;
                layui.laytpl(gettpl).render(datajson, function (html) {

                    document.getElementById('view').innerHTML = html;
                });
                init();
                layui.laypage({
                    cont: pageId,//容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
                    pages: datajson.pages,//总页数
                    skip: true, //是否开启跳页
                    skin: '#AF0000',//分页页数选中的背景色
                    curr: datajson.current || 1, //当前页,
                    jump: function (obj, first) {//触发分页后的回调
                        if (datajson.totalNums != 0) {
                            var oPNode = document.getElementById(pageId);//获取p节点的对象
                            var node = document.createElement('span');//创建一个文本节点
                            // node.setAttribute("class","layui-laypage-total");
                            node.innerHTML = "总条数:" + datajson.total + "条";
                            if (oPNode.firstElementChild != null)
                                oPNode.firstElementChild.appendChild(node);//将创建的文本内容插入到p节点中，追加方式

                        }
                        else
                            document.getElementById(pageId).innerHTML = '没有数据';
                        //$('pageId').html('看看URL的变化。通过hash，你可以记录当前页。当前正处于第'+obj.curr+'页');
                        if (!first) {//点击跳页触发函数自身，并传递当前页：obj.curr
                            queryPackageNew(urlAshx, obj.curr, dataMap, noteId, pageId)
                        }
                    }
                })
            }
        });
    }



    /**
     * 判断是否
     * @param functionType 判断是何种方法调用  remove删除 edit修改
     * @param tdNum        取第几个TD的数据作为返回参数
     * @returns {*}         remove删除 返回数组 edit修改 返回数字
     */
    judgePackage = function (functionType, tdNum) {

        var checkNum = $('table').find('tbody input[type="checkbox"]:checked').length;
        if (functionType == 'remove') {//删除
            if (checkNum == 0) {
                layer.msg("请选择一条需要删除的记录");
                return;
            }
            var delStr = new Array();
            $('table').find('tbody input[type="checkbox"]:checked').each(function () {
                if (this.checked) {
                    n = $(this).parents("tr").index() + 1;
                    delStr.push($('table').find("tr:eq(" + n + ")").children('td').eq(tdNum).text());
                }
            });

            return delStr;
        }

        if (functionType == 'edit') {//修改
            if (checkNum == 0) {
                layer.msg("请选择一条需要修改的记录");
                return;
            }
            if (checkNum - 1 > 0) {
                layer.msg("只能选择一条需要修改的记录");
                return;
            }
            $('table').find('tbody input[type="checkbox"]:checked').each(function () {
                n = $(this).parents("tr").index() + 1;
                selId = $('table').find("tr:eq(" + n + ")").children('td').eq(tdNum).text();
            });
            return selId;
        }
    }

})

