// pages/maps/map.ts
Page({

  /**
   * 页面的初始数据
   * []中括号代表集合数组
   * 
   * {}大括号一般代表对象
   */
  data: {
    lg:"113.922775",
    lt:"22.773672",
    mark:[
      {
        id:1,
        //维度
        longitude:"113.922775",
        //经度
        latitude:"22.773672",
        //定位图标
        iconPath:"../../imgs/定位.png",
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
    wx.getLocation({
      type: 'wgs84',
      success (res) {
        console.log(res)
      }
     })
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