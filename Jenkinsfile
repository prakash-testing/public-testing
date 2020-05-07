pipeline {
    agent none
    stages {
        stage('Build') {
            agent any
            steps {
		checkout scm
			}
		}
        stage('Test') {
            agent any
            steps {
                echo 'Runnig SE Grid Job'
                build 'selenium_grid_docker'
                echo 'Runnig Maven test'
                build 'test_code'
            }
        }
        stage('Deploy') {
		agent any
		when {branch 'master'}
        	steps {
		    sh 'echo env.BRANCH_NAME'	
                    echo 'Runnig Production Push as its master branch commit'
                    build 'prod_push'
            	}
	}	
    }
}
