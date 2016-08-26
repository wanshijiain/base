GET _search
{
  "query": {
    "match_all": {}
  }
}

GET _cat/health?v
GET _cat/nodes?v
GET _cat/indices?v
GET goods/?pretty
GET goods/_settings
GET goods/info/200
DELETE goods/info/200

PUT goods/info/200
{
  "name":"西瓜",
  "price":"2元/斤"
}
#覆盖了
POST goods/info/200
{
  "des":"又大又甜，不甜不要钱"
}
POST goods/info/200
{
  "des":"又大又甜，不甜不要钱",
  "sum":20
}
#老版本了，这个
POST goods/info/200
{
  "script" : "ctx._source.sum += 5"
}

POST goods/info/_count

#搜索所有的
GET goods/info/_search?q=*&pretty

#从第十条开始,返回两条结果,id逆序,指定返回字段
GET goods/info/_search
{
  "query": {
    "match_all": {}
  },
  "from": 10,
  "size": 2,
  "sort": {
    "id": {
      "order": "desc"
    }
  },
  "_source": [
    "id",
    "goodsName",
    "goodsShows"
  ]
}

GET goods/info/_search
{
  "query": {
    "match": {
      "id": 252
    }
  }
}


#第252号商品,goodsContext中包含'赔偿'的
GET goods/info/_search
{
  "query": {
    "match_phrase": {
      "goodsContext": "赔偿"
    }
  }
}

#配合多个match, must = and,should = or,must_not = both not,
#
GET goods/info/_search
{
  "query": {
    "bool": {
      "must": [
        {
          "match": {
            "goodsName": "春"
          }
        },
        {
          "match_phrase": {
            "goodsContext": "西瓜"
          }
        }
      ]
    }
  }
}

#过滤
GET goods/info/_search
{
  "query": {
    "bool": {
      "must": [
        {
          "match": {
            "goodsName": "春"
          }
        }
      ],
      "filter": {
        "range": {
          "saleNum": {
            "gte": 10,
            "lte": 49
          }
        }
      }
    }
  }
}

#聚合
#tantamount to :SELECT state, COUNT(*) FROM bank GROUP BY
#  state ORDER BY COUNT(*) DESC
GET goods/info/_search
{
  "size": 0,
  "aggs": {
    "group_by_state": {
      "terms": {
        "field": "types"
      }
    }
  }
}

#size=0 to not show hits.Only want to see aggs response.
#求集合中某个字段平均值,逆序排列
#range in group_by_types
#      "range": {
#        "field": "types",
#        "ranges": [
#          {
#            "from": 90,
#            "to": 150
#          }
#        ]
#      },
GET goods/info/_search
{
  "size": 0,
  "aggs": {
    "group_by_types": {
      "terms": {
        "field": "types",
        "order": {
          "average_balance": "desc"
        }
      },
      "aggs": {
        "average_balance": {
          "avg": {
            "field": "initNum"
          }
        }
      }
    }
  }
}