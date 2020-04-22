from SqLiteConnector import SqLiteConnector

def main():
    print("hey")
    connector = SqLiteConnector()
    #kein name
    connector.name_database('')
    connector.start_database_connection()
    connector.create_table('chat')
    connector.insert_to_table('chat', '20:45', 'Peter', 'Hallo')
    connector.insert_to_table('chat', '20:46', 'Max', 'Hallo')
    connector.insert_to_table('chat', '20:47', 'Gustavo', 'Hallo')

    connector.get_all_from_table('chat')
    rows = connector.cursor.fetchall()
    i, j, k = rows[0]
    print(''+i)
    print(''+j)
    print(''+k)

    i, j, k = rows[1]
    print(''+i)
    print(''+j)
    print(''+k)

    i, j, k = rows[2]
    print(''+i)
    print(''+j)
    print(''+k)

    print('heeey')
    # for row in rows:
    #     print(row)
    #
    # print("\n")
    # connector.search_in_table('chat', 'Peter')
    #
    # rows = connector.cursor.fetchall()
    # print(rows)

    connector.commit_changes()

    connector.close_table('chat')

    connector.close_database_connection()



if __name__ == '__main__':
    main()