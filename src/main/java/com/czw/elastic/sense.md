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

###########################################2016-08-29  中文分词器ik测试#############################################
GET _search
{
  "query": {
    "match_all": {}
  }
}

PUT index

POST index/fulltext/_mapping
{
    "fulltext": {
             "_all": {
            "analyzer": "ik_max_word",
            "search_analyzer": "ik_max_word",
            "term_vector": "no",
            "store": "false"
        },
        "properties": {
            "content": {
                "type": "string",
                "store": "no",
                "term_vector": "with_positions_offsets",
                "analyzer": "ik_max_word",
                "search_analyzer": "ik_max_word",
                "include_in_all": "true",
                "boost": 8
            }
        }
    }
}

POST index/fulltext/1
{"content":"美国中留给伊拉克的是个烂摊子吗"}

GET index/fulltext/1

POST index/fulltext/2
{"content":"公安部：各地校车将享最高路权"}

POST index/fulltext/3
{"content":"中韩渔警冲突调查：韩警平均每天扣1艘中国渔船"}

POST index/fulltext/4
{"content":"中国驻洛杉矶领事馆遭亚裔男子枪击 嫌犯已自首"}

POST index/fulltext/_search
{
    "query" : { "term" : { "content" : "中国" }},
    "highlight" : {
        "pre_tags" : ["<tag1>", "<tag2>"],
        "post_tags" : ["</tag1>", "</tag2>"],
        "fields" : {
            "content" : {}
        }
    }
}

GET goods/info/1

GET goods/info/_analyze?analyzer=ik_max_word&pretty&goodsContext=香蕉

POST goods/info/_setting
{
  "info": {
    "_all": {
      "analyzer": "ik_max_word",
      "search_analyzer": "ik_max_word",
      "term_vector": "no",
      "store": "false"
    },
    "properties": {
      "goodsContext": {
        "type": "string",
        "store": "no",
        "term_vector": "with_positions_offsets",
        "analyzer": "ik_max_word",
        "search_analyzer": "ik_max_word",
        "include_in_all": "true",
        "boost": 8
      }
    }
  }
}
##########################################################################################################
































