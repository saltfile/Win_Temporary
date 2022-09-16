// pages/maps/map.ts
var QQMapWX = require('../../libs/qqmap-wx-jssdk.js');
var qqmapsdk;
Page({

  /**
   * 页面的初始数据
   * []中括号代表集合数组
   * 
   * {}大括号一般代表对象
   */
  data: {
    lg:113.922775,
    lt:22.773672,
    mark:[
      {
        id:1,
        //维度
        longitude:113.922775,
        //经度
        latitude:22.773672,
        //定位图标
        iconPath:"",
        //定位的宽高
        width:"100rpx",
        height:"100rpx"
      }
    ]
  },

  /**
   * 生命周期函数--监听页面加载
   * 当前页面加载，就会去执行从硬盘上加载到内存中
   */
  onLoad() {
    var ress = this
    qqmapsdk = new QQMapWX({
      key: 'LNUBZ-HV3CJ-AKNFR-KRLJB-BIH7J-GVFPY'
  });
  
    wx.getLocation({
      isHighAccuracy: true, // 开启地图精准定位
      type: 'gcj02', // 地图类型写这个
      success: (res)=> {
        const lts = res.latitude
        const lgs = res.longitude
        const speed = res.speed
        const accuracy = res.accuracy
        console.log(speed, accuracy, lts, lgs)
let arr = []
var obj = {
  id:0,
  //维度
  longitude:res.longitude,
  //经度
  latitude:res.latitude,
  //定位图标
  iconPath:"/imgs/自我定位.png",
  //定位的宽高
  width:"100rpx",
  height:"100rpx"
}
arr.push(obj)
        ress.setData({
          lt:res.latitude,
          lg:res.longitude,
          mark:arr
        })
      },
      fail: function (errInfo) {
        console.info(errInfo)
      }
  });
  qqmapsdk.search({
    keyword: "停车场", // 关键字，跟一个input绑定
  page_size: 20,
  auto_extend: 1,
  location: {
    latitude: this.data.lt,
    longitude: this.data.lg
  },
  success : (res:any)=> {
    
    //这里的值已经可以拿到了d
    //TODO：明天将这里的结果放在markers上
    console.log(res)
    var datas = []
    datas = res.data
    let markArr = this.data.mark


    for(var i = 0;i <datas.length;i++){
      let obj = { 
        id : i+2,
        longitude:datas[i].location.lng,
        latitude:datas[i].location.lat,
        iconPath:"../../imgs/可用.png",
        width:"100rpx",
        height:"100rpx"}
        markArr.push(obj)
    }
    console.log("lab")
    console.log(markArr)
    ress.setData({
      mark:markArr
    })
    console.log(ress.data.mark)
  },
  fail: function (res:any) {
    console.log(res)
  },
});
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  }
})