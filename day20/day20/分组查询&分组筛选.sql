----�����ѯ&ɸѡѧϰ��
     --�ؼ��֣�group by �����ֶ���,�����ֶ���....
         --ע��1��ʹ���˷������select�����ֻ������ַ����ֶκͶ��к�����
         --ע��2������Ƕ��ֶη��飬���Ȱ��յ�һ�ֶη��飬Ȼ��ÿ��С��������յڶ����ֶμ������飬�Դ����ơ�
         --ע��3����where�Ӿ��в�������ֶ��к�����
     --����ɸѡ
         --�ؼ��֣�having
              --���ã���Է�����з���������ɸѡ������ʹ�ö��к�����
              --ע�⣺having�ؼ�����ͷ�����ʹ�á���������ʹ�á�   
              --where��having�ıȽϣ�
                 --where�Ӿ䲻������ֶ��к�����having������ֶ��к���
                 --where�Ӿ��having������ʹ����ͨ�ֶ�ֱ�ӽ���ɸѡ������where��Ч�ʸ���having
                    --whereִ��˳��: from--->where--->group by-->select-->order by
                    --havingִ��˳��:from--->group by-->select--->having--->order by
               --���ۣ��ڷ�������У�ʹ��where�����ֶμ����ɸѡ��ʹ��having���ж��к�����ɸѡ��    
      --��ѯ��߹��ʺ�Ա����
      select max(sal),count(*) from emp
      --��ѯ��ͬ���ŵ���߹���
      select deptno,max(sal) from emp group by deptno
      select * from emp
      --��ѯ��ͬ������λ��Ա����
      select job, count(*) from emp group by job
      --��ѯ��ͬ���ŵĲ�ͬ������λ������
      select deptno ,lower(job),count(*) from emp group by deptno,job order by deptno
      --��ѯ��ͬ���ŵĲ�ͬ������λ�Ĳ�����������1����Ϣ
      select deptno ,lower(job),count(*) from emp  group by deptno,job having count(*)>1 order by deptno
      --��ѯ���źŴ���10�Ĳ�ͬ���ŵĲ�ͬ������λ������
          --ʹ��having�ؼ���
          select deptno ,lower(job),count(*) from emp group by deptno,job  having deptno>10  order by deptno
          --ʹ��where�ؼ���
          select deptno,job,count(*) from emp where deptno>10 group by deptno,job  order by deptno
---SQL��ѯ���Ľṹ
        --select �Ӿ�                  Ҫ��ѯ������(oracle���������������ӷ���ȥ���ظ����߼�����)
        --from���                     ����Ҫ��ѯ�ı�(����)             
        --where�Ӿ�                    ɸѡ���ݣ�ɸѡ�������ؼ��֣�
        --group by�Ӿ�                 ����     �������ֶΣ�
        --having�Ӿ�                   ����ɸѡ   (���к���ɸѡ����)
        --order by�Ӿ�                 ����       ������
        --from-->where--->group by-->select--->having--->order by
        
        
        
        
        
      
