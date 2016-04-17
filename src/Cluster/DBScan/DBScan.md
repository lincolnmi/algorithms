##DBScan算法流程图

```
算法：DBScan，基于密度的聚类算法
输入：
   D：一个包含n个数据的数据集
   r：半径参数
   minPts：领域密度阈值
输出：基于密度的聚类集合
```
```
标记D中所有的点为unvisted
for each p in D
	if p.visit = unvisted
		找出与点p距离不大于r的所有点集合N
		If N.size() < minPts
		   标记点p为噪声点
		Else
		   for each p' in N
		       If p'.visit == unvisted
		          找出与点p距离不大于r的所有点集合N'
		            If N'.size()>=minPts
		                将集合N'加入集合N中去
		            End if
				Else
			        If p'未被聚到某个簇
			            将p'聚到当前簇
			            If p'被标记为噪声点
			               将p'取消标记为噪声点
				        End If
			         End If
			     End If
			 End for
		 End if
	 End if
End for

```