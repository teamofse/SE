<template id="commodity">
        <div class="tabbable" id="tabs-585381">
          <ul class="nav nav-tabs">
            <li class="active">
              <a href="#panel-52687" data-toggle="tab">
                <router-link to="/onsale"> 未卖出的</router-link>
              </a>
            </li>
            <li>
              <a href="#panel-96161" data-toggle="tab">
                <router-link to="/sold">已卖出的</router-link>
              </a>
            </li>
          </ul>
          <div class="tab-content">
            <div class="tab-pane active" id="panel-52687">
              <router-view></router-view>
            </div>
            <div class="tab-pane" id="panel-96161">
              <router-view></router-view>
            </div>
          </div>
        </div>
</template>

<script>
export default {

}
</script>

<style scoped>
#tabs-585381 {
  margin-top: 20px;
}
</style>
