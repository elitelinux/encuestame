<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp"%>
<div class="navbar navbar-fixed-top navbar-inverse" style="position: absolute;">
  <div class="navbar-inner">
    <div class="container">
        <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar">a</span>
            <span class="icon-bar">d</span>
            <span class="icon-bar">v</span>
        </a>
      <a class="brand" href="#">
            <%@ include file="/WEB-INF/layouts/logo.jsp"%>
      </a>
      <div class="nav-collapse collapse">
<!--           <ul class="nav">
            <li class="active">
                <a href="<%=request.getContextPath()%>/user/signin"> <spring:message
                                code="header.signin" />
                </a>
            </li>
            <li>
                <a href="#">
                    Link
                </a>
            </li>
            <li>
                <a href="#">
                    Link
                </a>
            </li>
          </ul> -->
          <ul class="nav pull-right">
            <c:if test="${logged}">
               <li>
                <a href="<%=request.getContextPath()%>/home">
                    <spring:message code="header.public.line" /> </a>
               </li>
            </c:if>
            <c:if test="${logged}">
               <li>
                    <a data-dojo-type="me/web/widget/menu/DashBoardMenu"
                       contextPath="<%=request.getContextPath()%>">
                    </a>
               </li>
            </c:if>
              <c:if test="${!logged}">
                  <li class="">
                        <a href="<%=request.getContextPath()%>/user/signin">
                            <spring:message code="header.signin" />
                        </a>
                  </li>
              </c:if>
              <form class="navbar-search pull-left" action="">
                         <div data-dojo-type="me/web/widget/menu/SearchMenu"></div>
              </form>
            </ul>
        </div>
    </div>
  </div>
</div>

<!-- TODO: check the style -->

<c:if test="${logged}">
    <div data-dojo-type="dojox/widget/UpgradeBar" id="upgradeBar2" data-dojo-props="noRemindButton:''" style="display:none;">
        <div validate="${!isActivated}">
            <span>
                <spring:message code="singup.account.not.validated" />
            </span>
            <a href="<%=request.getContextPath()%>/user/confirm/email/refresh/code">
                   <spring:message code="singup.account.send.code" />
            </a>
        </div>
    </div>
</c:if>
