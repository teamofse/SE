<template id="records">
  <div class="tabbable" id="tabs-585381">
    <ul class="nav nav-tabs">
      <li class="active">
        <a href="#panel-52687" data-toggle="tab">
          <router-link to="/arrived">已收到</router-link>
        </a>
      </li>
      <li>
        <a href="#panel-96161" data-toggle="tab">
          <router-link to="/unarrived">未收到</router-link>
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
    name: 'records'
  }
</script>

<style scoped>
  #tabs-585381 {
    margin-top: 20px;
  }
</style>
