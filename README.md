
This is ZipEditor by Uwe Voigt <https://sourceforge.net/p/zipeditor>
[mp](http://marketplace.eclipse.org/content/eclipse-zip-editor)
converted to Git.

## Converting CVS to Git

http://stackoverflow.com/questions/881158/is-there-a-migration-tool-from-cvs-to-git

mentions all:

- [git-cvsimport](https://www.kernel.org/pub/software/scm/git/docs/git-cvsimport.html)
- [cvs2git](http://cvs2svn.tigris.org/cvs2git.html)

Though cvs2git is said to be better it requires Python 2.4 (and not 3.0) installed.

I tried `git cvsimport` and `git git-cvsimport`

But then I found example at <http://fedoraproject.org/wiki/Importing_Docs_CVS_modules_to_git>

	git-cvsimport -d :pserver:anonymous@cvs.fedoraproject.org:/cvs/docs -S docs-common -v -C <GITREPODIR> -u -p x -a -A ~/authors.txt <MODULE>
	
Trying
	
	git-cvsimport -d :pserver:anonymous@zipeditor.cvs.sourceforge.net:/cvsroot/zipeditor -v -a -C ZipEditor113

`git-cvsimport` also was not found.

### Maven/tycho build

Only pom.xml files were added accept for ZipEditor-test

[ERROR] Internal error: java.lang.RuntimeException: No solution found because the problem is unsatisfiable.: [Unable to satisfy dependency from ZipEditor-test 1.1.0.qualifier to bundle org.junit4 0.0.0.; No solution found because the problem is unsatisfiable.] -> [Help 1]
org.apache.maven.InternalErrorException: Internal error: java.lang.RuntimeException: No solution found because the problem is unsatisfiable.: [Unable to satisfy dependency from ZipEditor-test 1.1.0.qualifier to bundle org.junit4 0.0.0.; No solution found because the problem is unsatisfiable.]

That is actually <https://github.com/open-archetypes/tycho-eclipse-plugin-archetype/issues/3>

#### Running tests

	mvn integration-test
	
Note that `mvn package` does not include running of unit test that are treated as integration tests,
and thus must be run after `package` phaze.
	

	