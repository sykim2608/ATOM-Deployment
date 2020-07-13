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
  <script>
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
                      <input type="text" value="" placeholder="Keywords">
                    </div>
                  </td>
                  <th>Service Name</th>
                  <td>
                    <div class="input type_01 m">
                      <input type="text" value="" placeholder="Keywords">
                    </div>
                  </td>
                  <th>Architecture</th>
                  <td>
                    <div class="input type_01 m">
                      <input type="text" value="" placeholder="Keywords">
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
            <button type="button" class="btn search"> Search </button>
          </div>
        </div>
        <div class="board_top">
          <div class="cell nth_01 total_result">
            Total List
            <span class="value"><em>123,124,124</em>rows</span>
          </div>
          <div class="cell nth_02 option_box">
            <div class="select type_03 line">
              <select>
                <option value="1">10 Line</option>
                <option value="2">50 Line</option>
                <option value="3">100 Line</option>
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
          <div class="tbody">
            <table>
              <colgroup>
                <col style="width:14%;">
                <col style="width:17%;">
                <col style="width:17%;">
                <col>
                <col style="width:14%;">
                <col style="width:14%;">
              </colgroup>
              <tbody>
                <tr>
                  <td>SP1001</td>
                  <td>Smart parking</td>
                  <td>manufacturing</td>
                  <td>SKT parking service</td>
                  <td><span class="state color_01">Creating</span></td>
                  <td>02.28.2018 00:00:00</td>
                </tr>
              </tbody>
            </table>
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
            <button type="button" class="btn type_01 primary">Create</button>
          </div>
        </div>

        <!-- Loading중 일때-->
        <div class="board_top">
          <div class="cell nth_01 total_result">
            Total List
            <span class="value"><em>0</em>rows</span>
          </div>
          <div class="cell nth_02 option_box">
            <div class="select type_03 line">
              <select>
                <option value="1">10 Line</option>
                <option value="2">50 Line</option>
                <option value="3">100 Line</option>
              </select>
            </div>
            <button class="btn icon type_03 s" type="button" title="Download">
              <i class="download"></i>Download
            </button>
          </div>
        </div>
        <!-- Loading -->
        <div class="table type_03 y_scroll">
          <div class="load_wrap">
            <div class="loading"><span></span></div>
          </div>
        </div>
        <br>

        <!-- 검색결과 내용이 없을때 -->
        <div class="board_top">
          <div class="cell nth_01 total_result">
            Total List
            <span class="value"><em>0</em>rows</span>
          </div>
          <div class="cell nth_02 option_box">
            <div class="select type_03 line">
              <select>
                <option value="1">10 Line</option>
                <option value="2">50 Line</option>
                <option value="3">100 Line</option>
              </select>
            </div>
            <button class="btn icon type_03 s" type="button" title="Download">
              <i class="download"></i>Download
            </button>
          </div>
        </div>
        <div class="table type_03 y_scroll">
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
                  <th scope="col" class="sort up">Service ID</th>
                  <th scope="col" class="sort">Service Name</th>
                  <th scope="col" class="sort">Architecture</th>
                  <th scope="col">Description</th>
                  <th scope="col" class="sort">Status</th>
                  <th scope="col" class="sort">Date</th>
                </tr>
              </thead>
            </table>
          </div>
          <!-- 검색결과 없음 -->
          <div class="no_data">
            There is no Data.
          </div>
        </div>

      </div>
      <!--//cont_wrap-->
    </div>
  </div>
</body>

</html>