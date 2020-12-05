# leetCodeHub
This is my leetcode record hub.
## record
### git-command
- git reset --hard  head^ : 恢复上一个版本，直接版本回退，丢失所有改动
- git reset --mixed head~1 : 恢复上一个版本，回退到暂存区
- git reset --soft 013ba68fd : 恢复上一个版本，commit之后撤回
- git commit --amend : 撤回注释
- git rm -r --cached xx.xx : 仅删除远端某些文件（-r 递归删除 --cached 仅删除远端）

- git tag -a v0.01 -m "version 0.0.1" : 添加标签
- git push origin --tags ： 推送标签

