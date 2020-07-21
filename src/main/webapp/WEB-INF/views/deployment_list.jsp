<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>ATOM</title>
  <script src="../../scripts/atom/jquery.1.11.2.min.js"></script>
  <!-- datetime, date, time -->
  <script src="../../scripts/atom/datetimepicker.moment.js"></script>
  <script src="../../scripts/atom/datetimepicker.js"></script>
  <!-- multiselect -->
  <script src="../../scripts/atom/bootstrap-multiselect.js"></script>
  <!-- 공통작성 -->
  <script src="../../scripts/atom/ui_common.js"></script>
  <link rel="shortcut icon" type="image/x-icon" href="../../images/atom/favicon.ico">
  <link rel="stylesheet" href="../../styles/atom/style.css">
  <!-- bootstrap 4.5-->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

  <!-- 첫 페이지 로딩 시 -->
  <script>
    $(document).ready(function(){
      $(".load_wrap").remove();
      $.ajax({   
         type:"GET",
         url: "/getList",
         dataType: "json",
         success: function(data) {
          if(data.length < 1) {
            $("#tbodyList").append("<div class=no_data id=" + '"tbodyEmpty"'+"> There is no Data.</div>");
          }                              
          var cnt = $("#selectLine option:checked").val();
          var total = 0;
          for(var i=0 in data) {
            if(i == cnt) break;
            total++;
            var dates = moment(data[i].date).utc().format('MM.DD.YYYY HH:mm:ss');
            $("#tbodyList").append("<tr><td><input type=" + '"' + "checkbox" + '"'+ "id=" + '"' + "checkData" + '"' + "value="+ '"' + data[i].serviceId + '"' + "></td><td>"+data[i].serviceId+"</td><td>"+data[i].serviceName+"</td><td>"+data[i].architecture+"</td><td>"+data[i].description+"</td><td><span class="+'"'+"state color_03"+'"'+">" +data[i].status+"</td><td>"+dates+"</td></tr>");
          }
          $("#total_result").append("<span id =" + '"' + "spanData" + '"'+ "class=" + '"value"' + "><em>" + total + "</em>rows</span>");
         },
         error: function() {
          alert("error");
         }
      });

      // Modal Create 창에서 Save 버튼 클릭 시
      $("#saveBtn").click(function() {
        var id = document.getElementById("svcId").value;
        var name = document.getElementById("svcName").value;
        var desc = document.getElementById("svcDesc").value;
        var archi = document.getElementById("svcArch").value;
        var dates = moment(new Date()).utc(+8);           
        var dataFormat = {serviceId : id, serviceName : name, architecture : archi, description : desc, status : "Success", date : dates};
        $("#tbodyEmpty").remove();
        $("#tbodyList").append("<tr><td><input type=" + '"' + "checkbox" + '"'+ "id=" + '"' + "checkData" + '"' + "value="+ '"' + id + '"' + "></td><td>"+id+"</td><td>"+name+"</td><td>"+archi+"</td><td>"+desc+"</td><td><span class="+'"'+"state color_03"+'"'+">" +"Success"+"</td><td>"+moment(dates).utc().format('MM.DD.YYYY HH:mm:ss')+"</td></tr>");
        var total = $("#spanData").text().replace("rows","")*1 + 1;
        $("#spanData").remove();
        $("#total_result").append("<span id =" + '"' + "spanData" + '"'+ "class=" + '"value"' + "><em>" + total + "</em>rows</span>");     

        $.ajax({
          type: "POST",
          contentType: "application/json",
          data: JSON.stringify(dataFormat),
          url: "/addList",
          error: function() {
            alert("error");
          }
        });
      });
       //Save 후 Create 창 초기화
       $(".modal").on("hidden.bs.modal", function() {
        $("#svcId").val("");
        $("#svcName").val("");
        $("#svcDesc").val("");
        $("#svcArch").val("");
      });

       //Modal Modify 창에서 SaveChanges 버튼 클릭 시
       $("#saveChangeBtn").click(function() {
        var id = document.getElementById("modifyId").value;
        var name = document.getElementById("modifyName").value;
        var desc = document.getElementById("modifyDesc").value;
        var archi = document.getElementById("modifyArch").value;
        var dataFormat = {serviceId : id, serviceName : name, architecture : archi, description : desc};

        //화면 업데이트 
        var modifyValue = $('input[id=checkData]:checked');
        var tr = modifyValue.parent().parent();
        var dates = tr.children().eq(6).text();        
        tr.empty();
        tr.append("<td><input type=" + '"' + "checkbox" + '"' + "id=" + '"' + "checkData" + '"' + "value="+ '"' + id + '"' + "></td><td>"+id+"</td><td>"+name+"</td><td>"+archi+"</td><td>"+desc+"</td><td><span class="+'"'+"state color_03"+'"'+">" +"Success"+"</td><td>"+dates+"</td>");

        $.ajax({
          type: "POST",
          contentType: "application/json",
          data: JSON.stringify(dataFormat),
          url: "/modifyList",
          error: function() {
            alert("error");
          }
        });
       });

    });
  </script>

  <!-- Line select option 변경 시 -->
  <script>
    $(function() {
      $("#selectLine").change(function() {
        $("#tbodyList").empty();
        $(".value").remove();
        $.ajax({
          type:"GET",
          url: "/getList",
          dataType: "json",
          success: function(data) {
            if(data.length < 1) {
              $("#tbodyList").append("<div class=no_data id=" + '"tbodyEmpty"'+"> There is no Data.</div>");
            } 
            var cnt = $("#selectLine option:checked").val();
            var total = 0;
            for(var i=0 in data) {
              if(i == cnt) break;
              total++;
              var dates = moment(data[i].date).utc().format('MM.DD.YYYY HH:mm:ss');
              $("#tbodyList").append("<tr><td><input type=" + '"' + "checkbox" + '"'+ "id=" + '"' + "checkData" + '"' + "value="+ '"' + data[i].serviceId + '"' + "></td><td>"+data[i].serviceId+"</td><td>"+data[i].serviceName+"</td><td>"+data[i].architecture+"</td><td>"+data[i].description+"</td><td><span class="+'"'+"state color_03"+'"'+">" +data[i].status+"</td><td>"+dates+"</td></tr>");
            }
            $("#total_result").append("<span id =" + '"' + "spanData" + '"'+ "class=" + '"value"' + "><em>" + total + "</em>rows</span>");
           },
           error: function() {
            alert("error");
           }
        });
      });
    });
  </script>

  <!-- Delete 버튼 클릭 시 -->
  <script type="text/javascript">
    function deleteClick() {
      var obj = $('input[id=checkData]:checked');
      var tr = obj.parent().parent();
      var dataFormat = {deploymentId : obj.val()};
      var result = confirm(obj.val() + "를 삭제하시겠습니까?");
      if(result) {
        tr.remove(); 
        var total = $("#spanData").text().replace("rows","") - 1;
        $("#spanData").remove();
        $("#total_result").append("<span id =" + '"' + "spanData" + '"'+ "class=" + '"value"' + "><em>" + total + "</em>rows</span>");
        $.ajax({
          type: "POST",
          contentType: "application/json",
          data: JSON.stringify(dataFormat),
          url: "/deleteList",
          error: function() {
            alert("delete fail");
          }
        });    
      }
    }
  </script>

  <!-- Modal 창 띄우기 -->
  <script>
    //Create 버튼 클릭 시
    function createClick() {      
      $('#createModal').modal();
    }

    //Modify 버튼 클릭 시 
    function modifyClick() {
      var modifyValue = $('input[id=checkData]:checked');
      var tr = modifyValue.parent().parent();
      var td = tr.children();
      var serviceName = td.eq(2).text();
      var architecture = td.eq(3).text();
      var serviceDesc = td.eq(4).text();
       $("#modifyId").val(modifyValue.val());
       $("#modifyName").val(serviceName);
       $("#modifyDesc").val(serviceDesc);
       $("#modifyArch").val(architecture);
      $('#modifyModal').modal();
    }
  </script>

  <!-- Search 버튼 클릭 시 -->
  <script type="text/javascript">
    function searchClick() {
      var svcId = document.getElementById("searchId").value;
      var svcName = document.getElementById("searchName").value;
      var Arc = document.getElementById("searchArc").value;
      var dataFormat = {serviceId : svcId, serviceName : svcName, architecture : Arc, status : "Success"};

      $.ajax({
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(dataFormat),
        url: "/findList",
        success: function(data) {
          $("#tbodyList").empty();
          $(".value").remove();
          if(data.length < 1) {
              $("#tbodyList").append("<div class=no_data id=" + '"tbodyEmpty"'+"> There is no Data.</div>");
          } 
          var total = 0;
          for(var i=0 in data) {
            total++;
            var dates = moment(data[i].date).utc().format('MM.DD.YYYY HH:mm:ss');
            $("#tbodyList").append("<<tr><td><input type=" + '"' + "checkbox" + '"'+ "id=" + '"' + "checkData" + '"' + "value="+ '"' + data[i].serviceId + '"' + "></td><td>"+data[i].serviceId+"</td><td>"+data[i].serviceName+"</td><td>"+data[i].architecture+"</td><td>"+data[i].description+"</td><td><span class="+'"'+"state color_03"+'"'+">" +data[i].status+"</td><td>"+dates+"</td></tr>");
          }
          $("#total_result").append("<span id =" + '"' + "spanData" + '"'+ "class=" + '"value"' + "><em>" + total + "</em>rows</span>");
        },
        error: function() {
          alert("error");
        }
      });

    }
  </script>

</head>
<body>
  <div class="header"></div>
  <div class="wrap">
    <div class="content">
      <ul class="breadcrumb">
        <li>Home</li>
        <li class="now">Deployment</li>
      </ul>
      <h2 class="h2">Deployment</h2>
      <div class="cont_wrap">
        <div class="search_area auto">
          <div class="search_box">
            <table>
              <tbody>
                <tr>
                  <th>Service ID</th>
                  <td>
                    <div class="input type_01 m">
                      <input type="text" value="" placeholder="Keywords" id = "searchId">
                    </div>
                  </td>
                  <th>Service Name</th>
                  <td>
                    <div class="input type_01 m">
                      <input type="text" value="" placeholder="Keywords" id = "searchName">
                    </div>
                  </td>
                  <th>Architecture</th>
                  <td>
                    <div class="input type_01 m">
                      <input type="text" value="" placeholder="Keywords" id = "searchArc">
                    </div>
                  </td>
                </tr>
                <tr>
                  <th>Status</th>
                  <td>
                    <div class="select type_01 s">
                      <select>
                        <option value="1">All</option>
                        <option value="2">Creating</option>
                        <option value="3">In Progress</option>
                        <option value="4">Success</option>
                        <option value="5">Fail</option>
                      </select>
                    </div>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
          <div class="btn_box">
            <button id="searchBtn"type="button" class="btn search" onclick="searchClick()"> Search </button>
          </div>
        </div>
        <div class="board_top">
          <div class="cell nth_01 total_result" id="total_result">
            Total List
          </div>
          <div class="cell nth_02 option_box">
            <div class="select type_03 line">
              <select id="selectLine" name="myselect">
                <option value="10">10 Line</option>
                <option value="50">50 Line</option>
                <option value="100">100 Line</option>
              </select>
            </div>
            <button class="btn icon type_03 s" type="button" title="Download">
              <i class="download"></i>Download
            </button>
          </div>
        </div>
        <!-- 검색결과 -->
        <div class="table type_03 y_scroll link">
          <div class="thead">
            <table>
              <colgroup>
                <col style="width:14%;">
                <col style="width:17%;">
                <col style="width:17%;">
                <col>
                <col style="width:14%;">
                <col style="width:14%;">
              </colgroup>
              <thead>
                <tr>
                  <th scope="col" class="sort down">Data Select</th>
                  <th scope="col" class="sort down">Service ID</th>
                  <th scope="col" class="sort">Service Name</th>
                  <th scope="col" class="sort">Architecture</th>
                  <th scope="col">Description</th>
                  <th scope="col" class="sort">Status</th>
                  <th scope="col" class="sort">Date</th>
                </tr>
              </thead>
            </table>
          </div>
          <div class="tbody" id="tbodyClass">     
          <!-- ***table *** -->        
            <table id="myTable">
              <colgroup>
                <col style="width:14%;">
                <col style="width:17%;">
                <col style="width:17%;">
                <col>
                <col style="width:14%;">
                <col style="width:14%;">
              </colgroup>
              <tbody id="tbodyList">
                <!-- <div class= no_data id="tbodyEmpty">There is no Data.</div> -->
                </tbody>
            </table>
          </div>
        </div>
        <!-- Loading -->
        <div class="table type_03 y_scroll" id="loading">
          <div class="load_wrap">
            <div class="loading"><span></span></div>
          </div>
        </div>
        <div class="cont_footer type_01">
          <div class="paging">
            <ul>
            <li><a href="#none" class="btn first"><span class="hidden">First</span></a></li>
            <li><a href="#none" class="btn before"><span class="hidden">Before</span></a></li>
            <li><a href="#none">1</a></li>
            <li><a href="#none">2</a></li>
            <li><a href="#none">3</a></li>
            <li><a href="#none" class="on">4</a></li>
            <li><a href="#none">5</a></li>
            <li><a href="#none" class="btn next"><span class="hidden">Next</span></a></li>
            <li><a href="#none" class="btn last"><span class="hidden">Last</span></a></li>
            </ul>
          </div>
          <div class="btn_area">
            <button type="button" class="btn type_01 primary" data-toggle="modal" onClick="createClick()">Create</button>
            <button type="button" class="btn type_01 primary" onClick="deleteClick()">Delete</button>
            <button type="button" class="btn type_01 primary" data-toggle="modal" onClick="modifyClick()">Modify</button>
          </div>
        </div>
          <!-- Create Deployment (Modal View) --> 
        	<div class="modal fade" id="createModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <h2 class="modal-title" id="myModalLabel">Create Deployment</h2>
                </div>
                <div class="modal-body">
                  <div class="modal-body1">
                    <div class="table type_03 detail">
                      <table>
                        <tbody>
                          <tr>
                            <th>
                              <span class="imp">Service ID</span>
                            </th>
                            <td>
                              <table class="td_value">
                                <tr>
                                  <td>
                                    <span class="label">Service ID</span>
                                    <div class="input type_01 m">
                                      <input type="text" value="" id="svcId" maxlength="10" placeholder="Service ID">
                                    </div>
                                  </td>
                                </tr>
                              </table>
                            </td>
                            </tr>
                          <tr>
                            <th>
                              <span class="imp">Service</span>
                            </th>                            
                            <td>
                              <table class="td_value">
                                <tr>
                                  <td>
                                    <span class="label">Service Name</span>
                                    <div class="input type_01 m" >
                                      <input type="text" value="" id="svcName" maxlength="15" placeholder="Service Name">
                                    </div>
                                  </td>
                                </tr>
                              </table>
                              <div class="value_wrap">
                                <span class="label">Description</span>
                                <div class="textarea type_01 xxl">
                                  <textarea name="" id="svcDesc" rows="2" maxlength="100" placeholder="Description"></textarea>
                                </div>
                              </div>
                            </td>
                          </tr>
                          <tr>
                            <th>
                              <span class="imp">Architecture</span>
                            </th>
                            <td>
                              <table class="td_value">
                                <tr>
                                  <td>
                                    <span class="label">Architecture</span>
                                    <div class="input type_01 m">
                                      <input type="text" value="" id="svcArch" maxlength="15" placeholder="Architecture">
                                    </div>
                                  </td>
                                </tr>
                              </table>
                            </td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="saveBtn" data-dismiss="modal">Save</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
              </div>              
            </div>
          </div>
        </div>
        <!-- Modify Deployment (Modal View) -->
        <div class="modal fade" id="modifyModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <h2 class="modal-title" id="myModalLabel">Modify Deployment</h2>
                </div>
                <div class="modal-body">
                  <div class="modal-body1">
                    <div class="table type_03 detail">
                      <table>
                        <tbody>
                          <tr>
                            <th>
                              <span class="imp">Service ID</span>
                            </th>
                            <td>
                              <table class="td_value">
                                <tr>
                                  <td>
                                    <span class="label">Service ID</span>
                                    <div class="input type_01 m">
                                      <input type="text" value="" id="modifyId" disabled="disabled">
                                    </div>
                                  </td>
                                </tr>
                              </table>
                            </td>
                          </tr>
                          <tr>
                            <th>
                              <span class="imp">Service</span>
                            </th>                            
                            <td>
                              <table class="td_value">
                                <tr>
                                  <td>
                                    <span class="label">Service Name</span>
                                    <div class="input type_01 m" >
                                      <input type="text" value="" id="modifyName" maxlength="15" placeholder="Service Name">
                                    </div>
                                  </td>
                                </tr>
                              </table>
                              <div class="value_wrap">
                                <span class="label">Description</span>
                                <div class="textarea type_01 xxl">
                                  <textarea name="" id="modifyDesc" rows="2" maxlength="100" placeholder="Description"></textarea>
                                </div>
                              </div>
                            </td>
                          </tr>
                          <tr>
                            <th>
                              <span class="imp">Architecture</span>
                            </th>
                            <td>
                              <table class="td_value">
                                <tr>
                                  <td>
                                    <span class="label">Architecture</span>
                                    <div class="input type_01 m">
                                      <input type="text" value="" id="modifyArch" maxlength="15" placeholder="Architecture">
                                    </div>
                                  </td>
                                </tr>
                              </table>
                            </td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="saveChangeBtn" data-dismiss="modal">Save Changes</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
              </div>              
            </div>
          </div>
        </div>
        <!-- end of modal -->
      </div>
    </div>
  </div>
</body>
</html>