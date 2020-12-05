# leetCodeHub
This is my leetcode record hub.
## record
### git-command
- git reset --hard  head^ : 恢复上一个版本，直接版本回退，丢失所有改动
- git reset --mixed head~1 : 恢复上一个版本，回退到暂存区
- git reset --soft 013ba68fd : 恢复上一个版本，commit之后撤回
- git revert 版本号 : 回退某个版本，且版本继续向前

- git tag -a v0.01 -m "version 0.0.1" : 添加标签
- git push origin --tags ： 推送标签

- git log --online : 查看历史提交记录 
- git commit --amend : 撤回注释
- git ls-files : 查看远端目录结构及文件名
- git rm -r --cached xx.xx : 仅删除远端某些文件（-r 递归删除 --cached 仅删除远端）

- merge(dev -> master ) 
  1. pull dev  2. checkout master  3. git merge dev 

- git merge : 合并分支-test - 01
