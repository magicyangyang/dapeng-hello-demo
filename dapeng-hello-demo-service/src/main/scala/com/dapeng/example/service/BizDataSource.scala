package com.dapeng.example.service

import javax.annotation.Resource
import javax.sql.DataSource

class BizDataSource {

  @Resource(name = "dataSource")
  def setBizDataSource(dataSource: DataSource): Unit ={
    BizDataSource.dataSource = dataSource
  }
}

object BizDataSource{
  var dataSource:DataSource = _
}

